package com.ocean.angel.tool.doucment.dto;

import lombok.Data;

import java.util.List;

/**
 * 接口数据结构
 */
@Data
public class ApiData {

    // 接口名称
    private String name;

    // 接口tag
    private String tag;

    // 请求方式
    private String type;

    // 接口地址
    private String path;

    // 接口参数
    private List<ApiParam> parameters;

    // 接口响应
    private List<ApiParam> responses;

    // 响应码
    private List<ApiResponseCode> codes;

    // 接口描述
    private String notes;
}
