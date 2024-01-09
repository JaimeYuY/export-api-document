package com.ocean.angel.tool.service;

import com.ocean.angel.tool.domain.entity.Channel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ocean.angel.tool.domain.qo.ChannelQuery;
import com.ocean.angel.tool.domain.vo.ChannelVO;
import com.ocean.angel.tool.domain.dto.ChannelDTO;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;

/**
 * 渠道信息 服务类
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
public interface ChannelService extends IService<Channel> {

    /**
     * @desc 分页查询
     *
     * @param query
     * @return com.ocean.angel.tool.common.PageResult<com.ocean.angel.tool.domain.vo.ChannelVO>
     */
    PageResult<ChannelVO> page(ChannelQuery query);

    /**
     * @desc 保存
     *
     * @param dto
     * @return com.ocean.angel.tool.common.ActionResult
     */
    ActionResult<Long> save(ChannelDTO dto);

    /**
     * @desc 更新
     *
     * @param dto
     * @return com.ocean.angel.tool.common.ActionResult
     */
    ActionResult<Long> update(ChannelDTO dto);

}
