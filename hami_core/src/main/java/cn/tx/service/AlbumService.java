package cn.tx.service;

import cn.tx.pojo.Album;
import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    Page<Album> findAll(Album album, Integer pageNo);
    int insert(Album album);
    public List<Album> selectByname(Map<String,String> map);
    int deleteByPrimaryKey(Integer aid);
    List<Album> selectobjectAll();
}
