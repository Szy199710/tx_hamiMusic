package cn.tx.controller;

import cn.tx.pojo.Album;
import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;
import cn.tx.service.AlbumService;
import cn.tx.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService AlbumService;

    @RequestMapping("/dofindAll")
    public String findAll(Album album, Integer pageNo, Model model){
        if(pageNo==null){
            pageNo=1;
        }
        //List<Mtype> mtypeList = mtypeService.findAll();
        //String aname = album.getAname();
        Page<Album> pageAlbum = AlbumService.findAll(album, pageNo);
        //PageObject<SysLog> pageObjects = logservice.findPageObjects(username, pageCurrent);
        model.addAttribute("page", pageAlbum);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("album", album);
        System.out.println("sdssd");
        System.out.println("test");
        return "album";
    }
    @ResponseBody
    @RequestMapping("/addAlbum")
    public String addAlbum(Album album){
        AlbumService.insert(album);
        return "success";
    }

    @ResponseBody
    @RequestMapping("isSname")
    public String isSname(String aname){
        String flag="false";
        Map<String,String> map=new HashMap<>();
        map.put("aname",aname);
        List<Album> albums = AlbumService.selectByname(map);
        if(albums.size() > 0 ){
            flag="true";
        }
        return flag;
    }
    @ResponseBody
    @RequestMapping("/delAlbum")
    public String delMtype(Integer aid){
        AlbumService.deleteByPrimaryKey(aid);
        return "success";
    }

}
