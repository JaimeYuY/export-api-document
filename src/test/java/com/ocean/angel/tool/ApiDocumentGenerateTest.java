package com.ocean.angel.tool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.ocean.angel.tool.doucment.dto.*;
import com.ocean.angel.tool.doucment.util.SwaggerApiDataHandlerUtil;
import com.ocean.angel.tool.util.WordUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
class ApiDocumentGenerateTest {

    @Test
    void handler() {

        // 接口文档基本信息
        DocumentData documentData = new DocumentData();
        documentData.setTitle("系统接口文档");
        documentData.setDate(DateUtil.formatDate(new Date()));
        documentData.setVersion("1.0.0");
        documentData.setHost("http://localhost:8090");
        documentData.setBasePath("/");
        documentData.setNotes("创建");

        try {
            // swagger /v2/api-docs 接口返回的数据
            String jsonString = HttpUtil.get("http://localhost:8090/v2/api-docs?group=系统WEB接口");
            SwaggerApiDataHandlerUtil.dataHandler(documentData, jsonString);
            log.info("{}", JSON.toJSONString(documentData));

            try {
                Map<String, Object> dataMap = new HashMap<>();
                // 生成需要导出表结构的word文件
                dataMap.put("data", documentData);
                WordUtil.generateWord(dataMap, "apiDocument.ftl", "ApiDocument.doc");
            } catch (Exception e) {
                log.error("generateTableStructure() error, {}", e.getMessage(), e);
            }

        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
