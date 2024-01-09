# 一键生成系统Word接口文档的基本思路和实现
## 基本思路
1. swagger提供的/v2/api-docs接口返回了系统所有接口数据结构信息，包括：请求参数、请求Url、响应数据、相应码等
2. 可以对该返回的数据去做解析，来构建符合Freemarker模板的数据
3. 通过Freemarker生成系统接口文档
4. 提供代码模板，一键生成代码，生成符合swagger规范的接口

## 基本实现
1. 设计word接口文档模板的基本板式和格式，在resources/templates/word中
2. 设计word接口文档模板的实体类格式，相关Bean在/document/dto中;
3. 使用代码模板一键生成系统功能接口，执行ApplicationTests.codeGeneration()方法即可
4. 启动系统，解析/v2/api-docs接口返回数据，组装数据使其符合步骤1设计的文档模板
5. 将word接口文档模板重命名为2003版的xml文件；
6. 用notepad++打开tables.xml，点击 插件 -> XMl tools-> Pretty print(libXML)，格式化xml文件；
7. 对数据进行变量替换
8. 保持系统启动状态，ApiDocumentGenerateTest.handler()一键生成系统接口文档;
9. 到resources/word下，查看生成的word接口文档
10. 更新文档目录，补充接口描述，补充接口实例等

## 使用指南
1. 去github上下载本系统的源码
2. 初始化sql脚本
3. 修改application.yml的数据库连接配置，并启动服务
4. 保持系统启动状态，执行ApiDocumentGenerateTest.handler()方法

本文使用的freemarker 变量替换的语句：
1. 接口文档基本信息
```
    ${data.title}
    ${data.date}
    ${data.version}
    ${data.notes}
```
2. TAG基本信息
```agsl
    <#list data.tags as tag>
        ${tag.name}
    </#list>
```
3. 接口基本信息
```agsl
    <#list tag.apis as api>
        ${api.name}
        ${api.path}
        ${api.type}
    </#list>
```
4. 接口参数信息
```agsl
    <#list api.parameters as param>
        ${param.name}
        ${param.type}
        ${param.requiredStr}
        ${param.description}
    </#list>
```
5. 响应参数信息
```agsl
    <#list api.responses as param>
        ${param.name}
        ${param.type}
        ${param.requiredStr}
        ${param.description}
    </#list>
```
6. 响应码信息
```agsl
    <#list api.code as item>
        ${item.code}
        ${item.msg}
    </#list>
```
## 一键生成的接口文档截图


	
	
	
	
	
	
	
	
	
	
	


