package cn.tx.web;

import cn.tx.pojo.JsonResult;
import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.ShiroException;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(ShiroException.class)
//    public JsonResult doShiroException(ShiroException e){
//        JsonResult r=new JsonResult();
//        r.setState(0);
//        if(e instanceof UnknownAccountException){
//            r.setMessage("用户名不存在");
//        }else if(e instanceof IncorrectCredentialsException){
//            r.setMessage("密码不正确");
//        }else{
//            r.setMessage("认证或授权失败");
//        }
//        return r;
//    }

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e){
        log.error("exception {}",e.getMessage());
        e.printStackTrace();
        return new JsonResult(e);
    }
}