package com.ocean.angel.tool.doucment.dto;

import lombok.Data;
import java.util.List;

/**
 * 文档数据结构
 */
@Data
public class DocumentData {

    // 文档标题
    private String title;

    // 文档版本
    private String version;

    // 文档修改时间
    private String date;

    // 域名
    private String host;

    // 地址前缀
    private String basePath;

    // 接口Tags
    private List<ApiTag> tags;

    // 备注
    private String notes;

}
