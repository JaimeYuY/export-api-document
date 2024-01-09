package com.ocean.angel.tool.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 数据字典
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Data
public class SysDictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，自增")
    private Long id;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "字典值")
    private String value;

    @ApiModelProperty(value = "排序号")
    private Integer sort;
}
