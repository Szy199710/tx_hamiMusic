package cn.tx.service.Impl;

import cn.tx.exception.ServiceException;
import cn.tx.mapper.AlbumMapper;
import cn.tx.pojo.Album;
import cn.tx.pojo.Page;
import cn.tx.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public Page<Album> findAll(Album album, Integer pageNo) {
        //1.对参数进行校验(可以自己校验，也可以借助框架：spring validation)
        if(pageNo==null||pageNo<1)
            throw new IllegalArgumentException("页码值不合法");//无效参数异常
        //2.基于查询条件查询总记录数并校验
        Integer totalCount = albumMapper.selectAllCount(album);
        if(totalCount==null)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页记录
        int pageSize=5;//页面大小，每页最多显示多少条记录
        int startIndex=(pageNo-1)*pageSize;//当前页起始位置
        List<Album> AlbumList = albumMapper.findAllmtypePage(album,startIndex, pageSize);
        //4.封装查询结果
        Page<Album> pageObjectAlbum=new Page<>(totalCount,AlbumList,pageSize,pageNo);

        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(queryWrapper);
        return pageObjectAlbum;
    }

    @Override
    public int insert(Album album) {
        int insert = albumMapper.insert(album);
        return insert;
    }

    @Override
    public List<Album> selectByname(Map<String, String> map) {
        List<Album> albums = albumMapper.selectByname(map);
        return albums;
    }

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        int delete = albumMapper.deleteId(aid);

        return delete;
    }

    @Override
    public List<Album> selectobjectAll() {
        List<Album> albumList = albumMapper.selectListAll();
        return albumList;
    }
}
