package cn.tx.mapper;

import cn.tx.pojo.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongMapper extends BaseMapper<Song> {
    Integer selectAllCount(@Param("song") Song song);
    List<Song> findAllmtypePage(@Param("song") Song song,
                                @Param("starIndex") int startIndex,
                                @Param("pageSize") int pageSize);
    void insertsong(@Param("song") Song song);
    @Delete("Delete from song where sid=#{sid}")
    void deleteSongById(Integer sid);
    List<Song> selectSongBySids(List<Integer> sids);
    Song selectSongBySid(int sid);
}
