package com.ocean.angel.tool.domain.qo;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.ocean.angel.tool.common.PageDomain;

/**
 * 渠道信息
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Data
public class ChannelQuery extends PageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "渠道名称")
    private String name;

    @ApiModelProperty(value = "审核状态：0-未审核，1-审核通过，2-审核不通过")
    private Boolean status;

}
