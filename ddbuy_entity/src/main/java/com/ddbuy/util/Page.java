package com.ddbuy.util;

import java.io.Serializable;

public class Page implements Serializable {
    private Integer page=1;//页面大小
    private Integer rows=5;//

    public Page(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Page() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
