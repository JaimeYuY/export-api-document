package com.ocean.angel.tool.controller;

import com.ocean.angel.tool.common.BaseController;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;
import com.ocean.angel.tool.domain.dto.SysDictDTO;
import com.ocean.angel.tool.domain.entity.SysDict;
import com.ocean.angel.tool.domain.qo.SysDictQuery;
import com.ocean.angel.tool.domain.vo.SysDictVO;
import com.ocean.angel.tool.service.SysDictService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 数据字典 前端控制器
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Api(value = "数据字典接口", tags = {"数据字典相关接口"})
@RestController
@RequestMapping("/sys/dict")
public class SysDictController extends BaseController {

    @Resource
    private SysDictService service;

    @ApiOperation(value = "数据字典列表", notes = "数据字典列表", consumes = "application/json", produces = "application/json", httpMethod = "GET")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @GetMapping("/list")
    public PageResult<SysDictVO> page(SysDictQuery query) {
        return service.page(query);
    }

    @ApiOperation(value = "获取数据字典信息", notes = "获取数据字典信息", consumes = "application/json", produces = "application/json", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据字典ID", required = true)
    })
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = SysDict.class),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @GetMapping("/get/{id}")
    public ActionResult<SysDict> get(@PathVariable Long id) {
        SysDict entity = service.getById(id);
        if(null == entity) {
            return ActionResult.error();
        }
        return ActionResult.success(entity);
    }

    @ApiOperation(value = "保存数据字典", notes = "保存数据字典", consumes = "application/json", produces = "application/json", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @PostMapping("/save")
    public ActionResult<Long> save(@RequestBody SysDictDTO dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "更新数据字典", notes = "更新数据字典", consumes = "application/json", produces = "application/json", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @PostMapping("/update")
    public ActionResult<Long> update(@RequestBody SysDictDTO dto) {
        return service.update(dto);
    }

    @ApiOperation(value = "删除数据字典", notes = "删除数据字典", consumes = "application/json", produces = "application/json", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据字典ID", required = true)
    })
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @DeleteMapping("/delete/{id}")
    public ActionResult<Void> delete(@PathVariable Long id) {
        service.removeById(id);
        return ActionResult.success();
    }

}
