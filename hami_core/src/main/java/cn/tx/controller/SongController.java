package cn.tx.controller;

import cn.tx.pojo.*;
import cn.tx.service.AlbumService;
import cn.tx.service.MtypeService;
import cn.tx.service.SongService;
import cn.tx.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongerService songerService;

    @Autowired
    private MtypeService mtypeService;

    @RequestMapping("/dofindAll")
    public String dofindAll(Song song, Integer pageNo,Model model){
        if(pageNo==null){
            pageNo=1;
        }
        //List<Mtype> mtypeList = mtypeService.findAll();
        //String aname = album.getAname();
        Page<Song> pageSong = songService.findAll(song, pageNo);
        //PageObject<SysLog> pageObjects = logservice.findPageObjects(username, pageCurrent);
        model.addAttribute("page", pageSong);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("song", song);
        List<Mtype> mtypes = mtypeService.selectobjectAll();
        model.addAttribute("mtypes",mtypes);
        return "song";
    }
    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<Mtype> mtypes = mtypeService.selectobjectAll();
        List<Album> albums = albumService.selectobjectAll();
        List<Songer> songers = songerService.selectobjectAll();
        model.addAttribute("mtypes",mtypes);
        model.addAttribute("albums", albums);
        model.addAttribute("songers", songers);
        return "addSong";
    }

    @RequestMapping("/add")
    public String add(Song song){
        songService.insert(song);
        return "redirect:/song/dofindAll";
    }
    @ResponseBody
    @RequestMapping("/delSong")
    public String delSong(Integer sid){
        songService.deleteByPrimaryKey(sid);
        return "success";
    }

}
