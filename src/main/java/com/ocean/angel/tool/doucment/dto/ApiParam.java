package com.ocean.angel.tool.doucment.dto;

import lombok.Data;

/**
 * 接口参数
 */
@Data
public class ApiParam {

    // 参数
    private String name;

    // 参数类型
    private String type;

    // 是否必填
    private Boolean required;

    private String requiredStr;

    // 参数说明
    private String description;

    // 参数引用
    private String ref;

    public String getDescription() {
        if(this.description == null) {
            return "";
        }
        return description;
    }

    public String getRequiredStr() {
        if(null == this.required) {
            this.required = false;
        }
        if(!this.required) {
            return "否";
        }
        return "是";
    }
}
