package cn.tx.service.Impl;

import cn.tx.exception.ServiceException;
import cn.tx.mapper.MtypeMapper;
import cn.tx.pojo.Mtype;
import cn.tx.pojo.Page;
import cn.tx.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MtypeServiceImpl implements MtypeService {

    @Autowired
    private MtypeMapper mtypeMapper;

    @Override
    public /*List<Mtype>*/ Page<Mtype> findAll(String tname,Integer pageNo) {
        //1.对参数进行校验(可以自己校验，也可以借助框架：spring validation)
        if(pageNo==null||pageNo<1)
            throw new IllegalArgumentException("页码值不合法");//无效参数异常
        //2.基于查询条件查询总记录数并校验
        int totalCount =mtypeMapper.getCount(tname);
        if(totalCount==0)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页记录
        int pageSize=5;//页面大小，每页最多显示多少条记录
        int startIndex=(pageNo-1)*pageSize;//当前页起始位置
        List<Mtype> mtypeList = mtypeMapper.findAllmtypePage(tname,startIndex, pageSize);
        //4.封装查询结果
        Page<Mtype> pageObjectMtype=new Page<Mtype>(totalCount,mtypeList,pageSize,pageNo);

        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(queryWrapper);
        return pageObjectMtype;
    }

    @Override
    public Mtype selectByPrimaryKey(Integer tid) {

        Mtype mtype = mtypeMapper.selectById(tid);

        return mtype;
    }

    @Override
    public int updateByPrimaryKeySelective(Mtype mtype) {

        int update = mtypeMapper.updateById(mtype);
        return update;
    }

    @Override
    public int insert(Mtype mtype) {

        int insert = mtypeMapper.insert(mtype);

        return insert;
    }

    @Override
    public int deleteByPrimaryKey(Integer tid) {

        int delete = mtypeMapper.deleteById(tid);

        return delete;
    }

    @Override
    public List<Mtype> selectobjectAll() {
        List<Mtype> mtypes = mtypeMapper.selectList(null);
        return mtypes;
    }

}
