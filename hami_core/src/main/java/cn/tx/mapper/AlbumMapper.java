package cn.tx.mapper;

import cn.tx.pojo.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface AlbumMapper extends BaseMapper<AlbumMapper> {
     Integer selectAllCount(@Param("album") Album album);
     List<Album> findAllmtypePage(@Param("album") Album album,
                                  @Param("startIndex") int startIndex,
                                  @Param("pageSize") int pageSize);
    int insert(@Param("album")Album album);

    List<Album> selectByname(Map<String, String> map);

    @Delete("Delete from album where aid=#{aid}")
    int deleteId(@Param("aid") Integer aid);
    @Select("select * from album")
    List<Album> selectListAll();
}
