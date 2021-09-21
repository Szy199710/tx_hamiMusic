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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/songer")
public class SongerController {

    @Autowired
    private SongerService songerService;

    @Autowired
    private MtypeService mtypeService;

    @RequestMapping("/dofindAll")
    public String dofindAll(Songer songer,Integer pageNo,Model model){
        if(pageNo==null){
            pageNo=1;
        }
        //List<Mtype> mtypeList = mtypeService.findAll();
        //String aname = album.getAname();
        Page<Songer> pageSonger = songerService.findAll(songer, pageNo);
        //PageObject<SysLog> pageObjects = logservice.findPageObjects(username, pageCurrent);
        model.addAttribute("page", pageSonger);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("songer", songer);
        List<Mtype> mtypes = mtypeService.selectobjectAll();
        model.addAttribute("mtypes",mtypes);
        return "songer";
    }
    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<Mtype> mtypes = mtypeService.selectobjectAll();
        model.addAttribute("mtypes",mtypes);
        return "addSonger";
    }
    @RequestMapping("/add")
    public String add(Songer songer){
        songerService.insert(songer);
        return "redirect:/songer/dofindAll";
    }

    @ResponseBody
    @RequestMapping("/delSonger")
    public String delMtype(Integer srid){
        songerService.deleteByPrimaryKey(srid);
        return "success";
    }
}
