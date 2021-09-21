package cn.tx.pojo;

import lombok.Data;

import java.io.Serializable;
//JsonResult是用于将后端多种用途的结果封装到一起返回给前端
@Data
public class JsonResult implements Serializable{
    private Integer state=1;
    private String message="ok";
    private  Object data;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Object data){
        this.data=data;
    }
    public  JsonResult(Throwable e){
        this.state = 0;
        this.message = e.getMessage();
    }
}