package com.jef.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jef
 * @date 2019/1/4
 */
public class Page<E> extends ArrayList<E> implements Cloneable {

    private static final long serialVersionUID = 5665186105465922634L;

    // public static final int NO_SQL_COUNT = -1;
// public static final int SQL_COUNT = 0;
    public static final int DFAULT_SIZE = 10;
    public static final int DFAULT_COUNT = 1;
    // 起始页
    private int pageNum;
    // 每页大小
    private int pageSize;
    // 起始行
    private int startRow;
    // 结束行
    private int endRow;
    // 总记录数
    private long total;
    // 页数
    private int pages;
    /**
     * 进行count查询的列名
     */
    private String countColumn;
    /**
     * 包含count查询
     */
    private boolean count = true;

    public Page(int pageNum, int pageSize) {
        this(pageNum, pageSize, true);
    }

    public Page(int pageNum, int pageSize, boolean count) {
        super(0);
        if (pageNum == 1 && pageSize == Integer.MAX_VALUE) {
            pageSize = -1;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        calculateStartAndEndRow();
    }
    public Page(int pageNum, int pageSize, int total) {
        super(pageSize);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        calculateStartAndEndRow();
    }

    /**
     * 计算开始行和结束行
     */
    private void calculateStartAndEndRow() {
        if (this.pageSize == -1) {
            this.startRow = 0;
            this.endRow = Integer.MAX_VALUE;
        } else {
            this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
            this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
        }
// this.endRow = pageNum * pageSize;
    }

    public List<E> getResult() {
        return this;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    // public Page<E> setPages(int pages) {
// this.pages = pages;
// return this;
// }
    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        if (total == -1) {
            pages = 1;
            return;
        }
        if (pageSize > 0) {
            pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
            pages = 0;
        }
    }

    public boolean isCount() {
        return this.count;
    }

    public Page<E> setCount(boolean count) {
        this.count = count;
        return this;
    }

    public String getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(String countColumn) {
        this.countColumn = countColumn;
    }

    @Override
    public String toString() {
        return "Page{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + ", startRow=" + startRow + ", endRow=" + endRow
                + ", total=" + total + ", pages=" + pages + '}';
    }


}