package cn.tx.service;

import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;

import java.util.List;

public interface MtypeService {
    //List<Mtype> findAll();
    Page<Mtype> findAll(String tname,Integer pageNo);
    Mtype selectByPrimaryKey(Integer tid);
    int updateByPrimaryKeySelective(Mtype mtype);
    int insert(Mtype mtype);
    int deleteByPrimaryKey(Integer tid);
    List<Mtype> selectobjectAll();
}
