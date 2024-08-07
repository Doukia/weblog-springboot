package com.zsk.weblog.web.controller;

import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱少康
 * @date 2024/8/7
 **/
@RestController
@RequestMapping("/statistics")
@Api(tags = "统计信息")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/info")
    @ApiOperationLog(description = "前台获取统计信息")
    @ApiOperation("前台获取统计信息")
    public Response findInfo() {
        return statisticsService.findInfo();
    }
}
