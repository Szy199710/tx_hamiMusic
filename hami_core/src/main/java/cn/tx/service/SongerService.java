package cn.tx.service;
import cn.tx.pojo.Page;
import cn.tx.pojo.Songer;

import java.util.List;

public interface SongerService {
    Page<Songer> findAll(Songer songer, Integer pageNo);
    void insert(Songer songer);
    void deleteByPrimaryKey(Integer srid);
    List<Songer> selectobjectAll();
    Songer selectSongerSongById(Integer srId);
}
