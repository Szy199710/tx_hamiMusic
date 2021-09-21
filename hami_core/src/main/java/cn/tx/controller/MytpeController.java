package cn.tx.controller;

import cn.tx.pojo.Album;
import cn.tx.pojo.JsonResult;
import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;
import cn.tx.service.AlbumService;
import cn.tx.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/mtype")
public class MytpeController {
    @Autowired
    private MtypeService mtypeService;

    @RequestMapping("/dofindAll")
    public String findAll(String tname,Integer pageNo,Model model){
        if(pageNo==null){
            pageNo=1;
        }
        //List<Mtype> mtypeList = mtypeService.findAll();
        Page<Mtype> pageMtype = mtypeService.findAll(tname, pageNo);
        //PageObject<SysLog> pageObjects = logservice.findPageObjects(username, pageCurrent);
        model.addAttribute("page", pageMtype);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("tname", tname);
        return "mtype";
    }
    @ResponseBody
    @RequestMapping("/selectMtype")
    public Mtype selectMtype(Integer tid){
        Mtype mtype = mtypeService.selectByPrimaryKey(tid);
        return mtype;
    }

    @ResponseBody
    @RequestMapping("/updateMtype")
    public String updateMtype(Mtype mtype){
        int i = mtypeService.updateByPrimaryKeySelective(mtype);
        System.out.println(i);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/addMtype")
    public String addMtype(Mtype mtype){
        mtypeService.insert(mtype);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/delMtype")
    public String delMtype(Integer tid){
        mtypeService.deleteByPrimaryKey(tid);
        return "success";
    }

}
