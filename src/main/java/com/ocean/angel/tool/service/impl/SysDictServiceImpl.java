package com.ocean.angel.tool.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;
import com.ocean.angel.tool.constants.ResultCode;
import com.ocean.angel.tool.domain.entity.SysDict;
import com.ocean.angel.tool.mapper.SysDictMapper;
import com.ocean.angel.tool.service.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ocean.angel.tool.domain.qo.SysDictQuery;
import com.ocean.angel.tool.domain.vo.SysDictVO;
import com.ocean.angel.tool.domain.dto.SysDictDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


/**
 * 数据字典 服务实现类
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Resource
    private SysDictMapper mapper;

    @Override
    public PageResult<SysDictVO> page(SysDictQuery query) {
        List<SysDictVO> data = mapper.listSysDict(query);
        int total = mapper.countSysDict(query);
        PageResult<SysDictVO> pageResult = PageResult.success(data, total);
        pageResult.setPageSize(query.getPageSize());
        pageResult.setPageNum(query.getPageNum());
        int pages = total % query.getPageSize() == 0 ? total / query.getPageSize() : total / query.getPageSize() + 1;
        pageResult.setPages(pages);
        return pageResult;
    }

    @Override
    @Transactional
    public ActionResult<Long> save(SysDictDTO dto) {
        SysDict entity = new SysDict();
        BeanUtil.copyProperties(dto, entity);
        mapper.insert(entity);
        return ActionResult.success(entity.getId());
    }

    @Override
    @Transactional
    public ActionResult<Long> update(SysDictDTO dto) {
        if(null == dto.getId()) {
            return ActionResult.error(ResultCode.PARAM_ERROR);
        }
        SysDict entity = new SysDict();
        BeanUtil.copyProperties(dto, entity);
        mapper.updateById(entity);
        return ActionResult.success(entity.getId());
    }
}
