package com.ocean.angel.tool.mapper;

import com.ocean.angel.tool.domain.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ocean.angel.tool.domain.qo.SysDictQuery;
import com.ocean.angel.tool.domain.vo.SysDictVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 数据字典 Mapper
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * @desc 数据字典列表
     *
     * @param query
     * @return java.util.List<com.ocean.angel.tool.domain.vo.SysDictVO>
     */
    List<SysDictVO> listSysDict(@Param("query") SysDictQuery query);

    /**
     * @desc 数据字典条数
     *
     * @param query
     * @return int
     */
    int countSysDict(@Param("query") SysDictQuery query);
}
