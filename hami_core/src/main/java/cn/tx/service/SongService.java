package cn.tx.service;

import cn.tx.pojo.Page;
import cn.tx.pojo.Song;

import java.util.List;

public interface SongService {
    Page<Song> findAll(Song song, Integer pageNo);
    void insert(Song song);
    void deleteByPrimaryKey(Integer sid);
    List<Song> selectSongBySids(List<Integer> sids);
    Song selectSongBySid(int sid);
}
