package cn.tx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("album")
@Data
@Accessors(chain=true)
public class Album extends BasePojo{
    @TableId(type= IdType.AUTO)
    private Integer aid;
    private String aname;
    private String pic;
    private String company;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date pdate;
    private String lang;


}