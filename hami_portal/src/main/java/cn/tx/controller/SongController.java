package cn.tx.controller;

import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;
import cn.tx.pojo.Song;
import cn.tx.service.MtypeService;
import cn.tx.service.SongService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private MtypeService mtypeService;

    @RequestMapping("/dofindAll")
    public String songlist(Song song, Integer pageNo, Model model){
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
        return "search";
    }
    /**
     *
     * 在cookie中存储历史播放  playids=12,34,5,67,8
     *
     * @return
     */
    @RequestMapping("/play")
    public String play(String sids, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        String[] idsArr = null;
        if(sids != null && !"".equals(sids)){
            idsArr = sids.split(",");
        }

        //获得cookie中的数据
        Cookie[] cookies = request.getCookies();
        String cookieIds = null;
        String[] idsArrCookie = null;
        if(cookies != null){
            for (Cookie cookie : cookies) {
                //获得cookie的名字
                String name = cookie.getName();
                if("playids".equals(name)){
                    cookieIds = cookie.getValue();
                    //解码
                    cookieIds = URLDecoder.decode(cookieIds, "UTF-8");
                }
            }
        }
        if(!StringUtils.isNullOrEmpty(cookieIds)){
            idsArrCookie = cookieIds.split(",");
        }
        //定义一个整数类型的集合
        List<Integer> sidsInt = new ArrayList<>();
        cookieIds = "";
        if(idsArr != null){
            for (String s : idsArr) {
                sidsInt.add(new Integer(s));
                cookieIds = cookieIds + s+ ",";
            }
            if(idsArrCookie != null){
                for (String s : idsArrCookie) {
                    Integer sid = new Integer(s);
                    boolean exists = false;
                    for (Integer i : sidsInt) {
                        if(sid.equals(i)){
                            exists = true;
                            break;
                        }
                    }
                    if(!exists){
                        sidsInt.add(sid);
                        cookieIds = cookieIds + s+ ",";
                    }
                }
            }


        }
        //防止后台的SQL报错
        if(sidsInt.size() == 0){
            sidsInt.add(-1);
        }

        List<Song> songs = songService.selectSongBySids(sidsInt);
        cookieIds = URLEncoder.encode(cookieIds, "UTF-8");
        Cookie cookie = new Cookie("playids", cookieIds);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        model.addAttribute("songs",songs);
        return "player";
    }
    @ResponseBody
    @RequestMapping("getSong")
    public Song getSong(Integer sid){
        Song song = songService.selectSongBySid(sid);
        return song;
    }
}
