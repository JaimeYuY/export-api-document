package com.ocean.angel.tool.common;

import com.ocean.angel.tool.constants.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总条数")
    private Integer total;

    @ApiModelProperty(value = "数据集合")
    private List<T> rows;

    @ApiModelProperty(value = "响应码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String msg;

    @ApiModelProperty(value = "页码，1-首页")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数据大小")
    private Integer pageSize;

    @ApiModelProperty(value = "总页数")
    private Integer pages;

    public PageResult() {
    }

    public PageResult(List<T> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public PageResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PageResult(Integer total, List<T> rows, int code, String msg) {
        this.total = total;
        this.rows = rows;
        this.code = code;
        this.msg = msg;
    }

    public PageResult(Integer total, List<T> rows, int code, String msg, int pageNum, int pageSize) {
        this.total = total;
        this.rows = rows;
        this.code = code;
        this.msg = msg;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }


    public static <T> PageResult<T> success(List<T> list, Integer total) {
        return new PageResult(total, list, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }

    public static <T> PageResult<T> success(List<T> list, Integer total, Integer pageNum, Integer pageSize) {
        return new PageResult(total, list, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), pageNum, pageSize);
    }

    public static <T> PageResult<T> error(ResultCode resultCode) {
        return new PageResult(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> PageResult<T> error() {
        return new PageResult(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMsg());
    }
}
