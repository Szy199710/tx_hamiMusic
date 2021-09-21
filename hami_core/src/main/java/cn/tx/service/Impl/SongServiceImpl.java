package cn.tx.service.Impl;

import cn.tx.exception.ServiceException;
import cn.tx.mapper.SongMapper;
import cn.tx.pojo.Page;
import cn.tx.pojo.Song;
import cn.tx.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public Page<Song> findAll(Song song, Integer pageNo) {
        //1.对参数进行校验(可以自己校验，也可以借助框架：spring validation)
        if(pageNo==null||pageNo<1)
            throw new IllegalArgumentException("页码值不合法");//无效参数异常
        //2.基于查询条件查询总记录数并校验
        Integer totalCount = songMapper.selectAllCount(song);
        if(totalCount==null)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页记录
        int pageSize=5;//页面大小，每页最多显示多少条记录
        int startIndex=(pageNo-1)*pageSize;//当前页起始位置
        List<Song> SongList = songMapper.findAllmtypePage(song,startIndex, pageSize);
        //4.封装查询结果
        Page<Song> pageObjectSong=new Page<>(totalCount,SongList,pageSize,pageNo);

        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(null);
        //List<Mtype> mtypeList = mtypeMapper.selectList(queryWrapper);



        return pageObjectSong;
    }

    @Override
    public void insert(Song song) {
        songMapper.insertsong(song);
    }

    @Override
    public void deleteByPrimaryKey(Integer sid) {
        songMapper.deleteSongById(sid);
    }

    @Override
    public List<Song> selectSongBySids(List<Integer> sids) {
        return songMapper.selectSongBySids(sids);
    }

    @Override
    public Song selectSongBySid(int sid) {
        return songMapper.selectSongBySid(sid);
    }
}
