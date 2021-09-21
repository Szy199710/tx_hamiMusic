package cn.tx.pojo;

import java.util.List;

/**
 * 提供分页的Page工具类对象
 */
public class Page<T> {

    /**
     * 每页的记录数(已知)
     */
    private int pageSize=5;
    /**
     *页码(已知，从前台页面传递过来)
     */
    private int pageNo=1;
    /**
     * 开始行号(未知，需要计算根据前两个已知计算  startNum = （pageNo-1）* pageSize)
     */
    private int startNum=0;


    /**
     * 指定条件下的总页数(未知，需要计算)
     */
    private int totalPage=1;
    /**
     * 指定条件下的总记录数(未知，需要计算 查询数据库来获得)
     */
    private int totalCount=0;

    /**
     * 结果集
     */
    private List<T> list;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartNum() {
        return (pageNo-1)* pageSize;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    /**
     *
     * totalCount(总记录数)     pageSize(每页数目)   totalPage(总页数)
     *      0                      10                     1
     *      55                     10                     6
     *      100                    10                     10
     *      第一种情况（能够整除）   totalpage=totalCount/pageSize；
     *      第二种情况(totalCount=0或者(取余)totalCount%pageSize！=0)   totalPage要加一；
     */
    public int getTotalPage() {
        totalPage=totalCount/pageSize;
        if(totalCount==0 || totalCount%pageSize!=0){
            totalPage++;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page() {
    }

    public Page(Integer totalCount, List<T> list, Integer pageSize, Integer pageNo) {
        this.totalCount = totalCount;
        this.list = list;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalPage=this.totalCount/this.pageSize;
        if(this.totalCount%this.pageSize!=0)
            this.totalPage++;
    }
}
