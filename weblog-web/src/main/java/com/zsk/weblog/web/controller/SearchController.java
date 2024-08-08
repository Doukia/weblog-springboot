package com.zsk.weblog.web.controller;

import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.search.SearchArticlePageListReqVO;
import com.zsk.weblog.web.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱少康
 * @date 2024/8/8
 **/
@RestController
@Api(tags = "搜索")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/article/search")
    @ApiOperationLog(description = "文章搜索")
    @ApiOperation("文章搜索")
    public Response searchArticlePageList(@RequestBody @Validated SearchArticlePageListReqVO searchArticlePageListReqVO) {
        return searchService.searchArticlePageList(searchArticlePageListReqVO);
    }
}
