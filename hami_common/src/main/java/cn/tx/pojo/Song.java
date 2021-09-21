package cn.tx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("song")
@Data
@Accessors(chain=true)
public class Song extends BasePojo{
    @TableId(type= IdType.AUTO)
    private Integer sid;

    private Integer tid;

    private Integer srid;

    private Integer aid;

    private String sname;

    private String pic;

    private String mp3;

    private Integer isHot;

    private Integer isNew;

    private Integer ptimes;

    private Integer auditStatus;

    private Integer showStatus;

    private String lrc;
    private String srname;
    private String aname;
    private Mtype mtype;
    private Songer songer;
    private Album album;
    //private Integer pageNoPortal = 1;
    //每页展示数量
    private Integer pageNo=1;
    private Integer pageSize=5;
}
