package cn.tx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tx_user")
@Data
@Accessors(chain=true)
public class User {
    @TableId(type= IdType.AUTO)
    private Integer userId;
    private String username;
    private String password;
    private String qq;
    private String email;
    private String nick;
    private String tel;
    private Date regTime;

}
