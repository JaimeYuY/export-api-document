package com.ocean.angel.tool.domain.qo;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.ocean.angel.tool.common.PageDomain;

/**
 * 数据字典
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Data
public class SysDictQuery extends PageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "字典值")
    private String value;
}
