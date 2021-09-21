//package cn.tx.controller;
//
//import cn.tx.pojo.JsonResult;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @RequestMapping("/doLogin")
//    public JsonResult doLogin(String username, String password){
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        Subject currentUser = SecurityUtils.getSubject();
//        currentUser.login(token);
//        return new JsonResult("login ok");
//    }
//
//}
