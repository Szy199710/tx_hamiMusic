package cn.tx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("songer")
@Data
@Accessors(chain=true)
public class Songer extends BasePojo {
    @TableId(type= IdType.AUTO)
    private Integer srid;

    private Integer tid;

    private String srname;

    private String area;

    private String pic;

    private Integer isHot;

    private String intro;

    private Mtype mtype;
    //private Integer pageNoPortal = 1;
    //每页展示数量
    private Integer pageNo=1;
    private Integer pageSize;

    private List<Song> songs;
}
