package com.zsk.weblog.web.controller;

import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.service.BlogSettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
@RestController
@RequestMapping("/blog/settings")
@Api(tags = "博客设置")
public class BlogSettingsController {

    @Autowired
    private BlogSettingsService blogSettingsService;

    @PostMapping("/detail")
    @ApiOperationLog(description = "前台获取博客详情")
    @ApiOperation("前台获取博客详情")
    public Response findDetail() {
        return blogSettingsService.findDetail();
    }
}
