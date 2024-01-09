package com.ocean.angel.tool.mapper;

import com.ocean.angel.tool.domain.entity.Channel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ocean.angel.tool.domain.qo.ChannelQuery;
import com.ocean.angel.tool.domain.vo.ChannelVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 渠道信息 Mapper
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
public interface ChannelMapper extends BaseMapper<Channel> {

    /**
     * @desc 渠道信息列表
     *
     * @param query
     * @return java.util.List<com.ocean.angel.tool.domain.vo.ChannelVO>
     */
    List<ChannelVO> listChannel(@Param("query") ChannelQuery query);

    /**
     * @desc 渠道信息条数
     *
     * @param query
     * @return int
     */
    int countChannel(@Param("query") ChannelQuery query);
}
