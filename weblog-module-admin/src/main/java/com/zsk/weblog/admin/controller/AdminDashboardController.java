package com.zsk.weblog.admin.controller;

import com.zsk.weblog.admin.service.AdminDashboardService;
import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱少康
 * @date 2024/7/28
 **/
@RestController
@RequestMapping("/admin/dashboard")
@Api(tags = "Admin 仪表盘")
public class AdminDashboardController {

    @Autowired
    private AdminDashboardService adminDashboardService;

    @PostMapping("/statistics")
    @ApiOperationLog(description = "获取后台仪表盘基础统计信息")
    @ApiOperation("获取后台仪表盘基础统计信息")
    public Response findDashboardStatistics() {
        return adminDashboardService.findDashboardStatistics();
    }

    @PostMapping("/publishArticle/statistics")
    @ApiOperationLog(description = "获取后台仪表盘文章发布热点统计信息")
    @ApiOperation("获取后台仪表盘文章发布热点统计信息")
    public Response findDashboardPublishArticleStatistics() {
        return adminDashboardService.findDashboardPublishArticleStatistics();
    }

    @PostMapping("/pv/statistics")
    @ApiOperationLog(description = "获取后台仪表盘最近一周 PV 访问量信息")
    @ApiOperation("获取后台仪表盘最近一周 PV 访问量信息")
    public Response findDashboardPVStatistics() {
        return adminDashboardService.findDashboardPVStatistics();
    }
}
