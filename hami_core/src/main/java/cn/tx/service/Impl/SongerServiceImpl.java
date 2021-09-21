package cn.tx.service.Impl;

import cn.tx.exception.ServiceException;
import cn.tx.mapper.SongerMapper;
import cn.tx.pojo.Page;
import cn.tx.pojo.Songer;
import cn.tx.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongerServiceImpl implements SongerService {

    @Autowired
    private SongerMapper songerMapper;

    @Override
    public Page<Songer> findAll(Songer songer, Integer pageNo) {
        //1.对参数进行校验(可以自己校验，也可以借助框架：spring validation)
        if(pageNo==null||pageNo<1)
            throw new IllegalArgumentException("页码值不合法");//无效参数异常
        //2.基于查询条件查询总记录数并校验
        Integer totalCount = songerMapper.selectAllCount(songer);
        if(totalCount==null)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页记录
        if(songer.getPageSize()==null) {
            songer.setPageSize(5);//页面大小，每页最多显示多少条记录
        }
        int startIndex=(pageNo-1)*songer.getPageSize();//当前页起始位置
        List<Songer> SongerList = songerMapper.findAllmtypePage(songer,startIndex, songer.getPageSize());
        //4.封装查询结果
        Page<Songer> pageObjectSonger=new Page<>(totalCount,SongerList,songer.getPageSize(),pageNo);

        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(queryWrapper);
        return pageObjectSonger;
    }

    @Override
    public void insert(Songer songer) {
        songerMapper.insert(songer);
    }

    @Override
    public void deleteByPrimaryKey(Integer srid) {
        songerMapper.deleteById(srid);
    }

    @Override
    public List<Songer> selectobjectAll() {
        List<Songer> songerList = songerMapper.selectListAll();
        return songerList;
    }

    @Override
    public Songer selectSongerSongById(Integer srId) {
        return songerMapper.selectSongerSongById(srId);
    }
}
