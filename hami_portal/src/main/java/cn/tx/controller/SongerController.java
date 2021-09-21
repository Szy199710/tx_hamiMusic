package cn.tx.controller;

import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;
import cn.tx.pojo.Songer;
import cn.tx.service.MtypeService;
import cn.tx.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("songer")
public class SongerController {

    @Autowired
    private SongerService songerService;
    @Autowired
    private MtypeService mtypeService;

    @RequestMapping("/dofindAll")
    public String songlist(Songer songer, Integer pageNo, Model model){
        if(pageNo==null){
            pageNo=1;
        }
        songer.setPageSize(20);

        //List<Mtype> mtypeList = mtypeService.findAll();
        //String aname = album.getAname();
        Page<Songer> pageSong = songerService.findAll(songer, pageNo);
        //List<Songer> songerList = songerService.selectobjectAll();
        //拿出20条数据
        List<Songer> list = pageSong.getList();

        List<List<Songer>> sList = new ArrayList<>();

        List<Songer> subList = null;
        for (int i = 0; i <list.size(); i++) {
            //每五个对象放入一个集合
            if(i % 5 == 0){
                subList = new ArrayList<>();
                sList.add(subList);
            }
            Songer songer1 = list.get(i);
            subList.add(songer1);
        }


        //PageObject<SysLog> pageObjects = logservice.findPageObjects(username, pageCurrent);
        model.addAttribute("page", pageSong);
        model.addAttribute("sList", sList);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("songer", songer);
        List<Mtype> mtypes = mtypeService.selectobjectAll();
        model.addAttribute("mtypes",mtypes);

        return "songers";
    }
    @RequestMapping("/getSonger")
    public String getSonger(Integer srId, Model model){
        Songer songer = songerService.selectSongerSongById(srId);
        model.addAttribute("songer", songer);
        return "songer";
    }

}
