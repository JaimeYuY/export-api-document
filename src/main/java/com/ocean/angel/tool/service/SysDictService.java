package com.ocean.angel.tool.service;

import com.ocean.angel.tool.domain.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ocean.angel.tool.domain.qo.SysDictQuery;
import com.ocean.angel.tool.domain.vo.SysDictVO;
import com.ocean.angel.tool.domain.dto.SysDictDTO;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;

/**
 * 数据字典 服务类
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
public interface SysDictService extends IService<SysDict> {

    /**
     * @desc 分页查询
     *
     * @param query
     * @return com.ocean.angel.tool.common.PageResult<com.ocean.angel.tool.domain.vo.SysDictVO>
     */
    PageResult<SysDictVO> page(SysDictQuery query);

    /**
     * @desc 保存
     *
     * @param dto
     * @return com.ocean.angel.tool.common.ActionResult
     */
    ActionResult<Long> save(SysDictDTO dto);

    /**
     * @desc 更新
     *
     * @param dto
     * @return com.ocean.angel.tool.common.ActionResult
     */
    ActionResult<Long> update(SysDictDTO dto);

}
