package com.ocean.angel.tool.doucment.dto;

import lombok.Data;

/**
 * 接口响应数据
 */
@Data
public class ApiResponseCode {

    // 响应码
    private String code;

    // 提示信息
    private String msg;
}
