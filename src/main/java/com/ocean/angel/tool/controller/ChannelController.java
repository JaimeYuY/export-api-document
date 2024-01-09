package com.ocean.angel.tool.controller;

import com.ocean.angel.tool.common.BaseController;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ocean.angel.tool.common.ActionResult;
import com.ocean.angel.tool.common.PageResult;
import com.ocean.angel.tool.domain.dto.ChannelDTO;
import com.ocean.angel.tool.domain.entity.Channel;
import com.ocean.angel.tool.domain.qo.ChannelQuery;
import com.ocean.angel.tool.domain.vo.ChannelVO;
import com.ocean.angel.tool.service.ChannelService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 渠道信息 前端控制器
 *
 * @author Jaime.yu
 * @time 2024-01-08
 */
@Api(value = "渠道信息接口", tags = {"渠道信息相关接口"})
@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseController {

    @Resource
    private ChannelService service;

    @ApiOperation(value = "渠道信息列表", notes = "渠道信息列表", consumes = "application/json", produces = "application/json", httpMethod = "GET")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @GetMapping("/list")
    public PageResult<ChannelVO> page(ChannelQuery query) {
        return service.page(query);
    }

    @ApiOperation(value = "获取渠道信息信息", notes = "获取渠道信息信息", consumes = "application/json", produces = "application/json", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "渠道信息ID", required = true)
    })
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Channel.class),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @GetMapping("/get/{id}")
    public ActionResult<Channel> get(@PathVariable Long id) {
        Channel entity = service.getById(id);
        if(null == entity) {
            return ActionResult.error();
        }
        return ActionResult.success(entity);
    }

    @ApiOperation(value = "保存渠道信息", notes = "保存渠道信息", consumes = "application/json", produces = "application/json", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @PostMapping("/save")
    public ActionResult<Long> save(@RequestBody ChannelDTO dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "更新渠道信息", notes = "更新渠道信息", consumes = "application/json", produces = "application/json", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 50000, message = "service exception")
    })
    @PostMapping("/update")
    public ActionResult<Long> update(@RequestBody ChannelDTO dto) {
        return service.update(dto);
    }

    @ApiOperation(value = "删除渠道信息", notes = "删除渠道信息", consumes = "application/json", produces = "application/json", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "渠道信息ID", required = true)
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
