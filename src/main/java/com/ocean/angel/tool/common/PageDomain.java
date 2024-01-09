package com.ocean.angel.tool.common;

import io.swagger.annotations.ApiModelProperty;

public class PageDomain {

    /***
     * 页码
     */
    @ApiModelProperty(value = "页码，1-首页")
    private Integer pageNum;

    /***
     * 页面条数
     */
    @ApiModelProperty(value = "每页数据大小")
    private Integer pageSize;

    private int start;

    public int getStart() {
        if(null == pageNum || pageNum < 1) {
            this.pageNum = 1;
        }

        if(null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        return (pageNum - 1) * pageSize;
    }

    public int getPageSize() {
        if(null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
