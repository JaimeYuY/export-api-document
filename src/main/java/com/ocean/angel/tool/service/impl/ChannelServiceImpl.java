package com.ocean.angel.tool.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;
import com.ocean.angel.tool.constants.ResultCode;
import com.ocean.angel.tool.domain.entity.Channel;
import com.ocean.angel.tool.mapper.ChannelMapper;
import com.ocean.angel.tool.service.ChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ocean.angel.tool.domain.qo.ChannelQuery;
import com.ocean.angel.tool.domain.vo.ChannelVO;
import com.ocean.angel.tool.domain.dto.ChannelDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


/**
 * 渠道信息 服务实现类
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements ChannelService {

    @Resource
    private ChannelMapper mapper;

    @Override
    public PageResult<ChannelVO> page(ChannelQuery query) {
        List<ChannelVO> data = mapper.listChannel(query);
        int total = mapper.countChannel(query);
        PageResult<ChannelVO> pageResult = PageResult.success(data, total);
        pageResult.setPageSize(query.getPageSize());
        pageResult.setPageNum(query.getPageNum());
        int pages = total % query.getPageSize() == 0 ? total / query.getPageSize() : total / query.getPageSize() + 1;
        pageResult.setPages(pages);
        return pageResult;
    }

    @Override
    @Transactional
    public ActionResult<Long> save(ChannelDTO dto) {
        Channel entity = new Channel();
        BeanUtil.copyProperties(dto, entity);
        mapper.insert(entity);
        return ActionResult.success(entity.getId());
    }

    @Override
    @Transactional
    public ActionResult<Long> update(ChannelDTO dto) {
        if(null == dto.getId()) {
            return ActionResult.error(ResultCode.PARAM_ERROR);
        }
        Channel entity = new Channel();
        BeanUtil.copyProperties(dto, entity);
        mapper.updateById(entity);
        return ActionResult.success(entity.getId());
    }
}
