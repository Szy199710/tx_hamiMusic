package cn.tx.mapper;

import cn.tx.pojo.Songer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongerMapper extends BaseMapper<Songer> {
    Integer selectAllCount(@Param("songer") Songer songer);
    List<Songer> findAllmtypePage(@Param("songer") Songer songer,
                                  @Param("starIndex") int startIndex,
                                  @Param("pageSize") int pageSize);

    @Select("Select * from songer")
    List<Songer> selectListAll();

    Songer selectSongerSongById(Integer srId);

}
