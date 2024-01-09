package com.ocean.angel.tool.doucment.dto;

import lombok.Data;
import java.util.List;

@Data
public class ApiTag {

    // 接口Tag名称
    private String name;

    // Tag接口列表
    private List<ApiData> apis;
}
