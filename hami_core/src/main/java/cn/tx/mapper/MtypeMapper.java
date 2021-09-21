package cn.tx.mapper;

import cn.tx.pojo.Album;
import cn.tx.pojo.Mtype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MtypeMapper extends BaseMapper<Mtype> {
    /*Linux系统中严格区分大小写,所以表名及字段都必须与表一致...
     * 老师为什么我的程序在windows中正常执行 ,linux中报错???
     * */
    @Select("select count(*) from mtype where tname like '%${tname}%'")
    int getCount(@Param("tname") String tname);
    @Select("select * from mtype  where tname like '%${tname}%' limit #{startIndex},#{pageSize}")
    List<Mtype> findAllmtypePage(@Param("tname")String tname,@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

}
