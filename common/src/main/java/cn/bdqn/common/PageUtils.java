package cn.bdqn.common;

/**
 * @Package: pro.jc.common
 * @Description: 分页工具类
 * @Author JC
 * @Create 2021年03月21日 20时52分00秒
 */

import java.util.List;

/**
 * PageUtils
 *
 * @author Jc
 * @date 2021/3/21 - 20:52
 */
public class PageUtils<T> {
    /**
     * 分页中的数据
     */
    private List<T> datas;
    /**
     * 当前页数
     */
    private Integer pageNo;
    /**
     * 每页最大数据数
     */
    private Integer maxPageSize;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 总数据数
     */
    private Integer total;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPages() {
        return pages;
    }

    private void setPages(Integer pages) {
        this.pages = (total + this.maxPageSize - 1) / this.maxPageSize;
    }

    public Integer getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(Integer maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer totalSize) {
        this.total = totalSize;
        setPages(totalSize); //设置页数
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "datas=" + datas +
                ", pageNo=" + pageNo +
                ", maxPageSize=" + maxPageSize +
                ", pages=" + pages +
                ", total=" + total +
                '}';
    }
}
