package com.zsk.weblog.admin.controller;

import com.zsk.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.zsk.weblog.admin.model.vo.tag.AddTagReqVO;
import com.zsk.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.zsk.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.zsk.weblog.admin.model.vo.tag.SearchTagReqVO;
import com.zsk.weblog.admin.service.AdminCategoryService;
import com.zsk.weblog.admin.service.AdminTagService;
import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.PageResponse;
import com.zsk.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱少康
 * @date 2024/7/20
 **/
@RestController
@RequestMapping("/admin/tag")
@Api(tags = "Admin 标签模块")
public class AdminTagController {

    @Autowired
    private AdminTagService adminTagService;

    @PostMapping("/add")
    @ApiOperationLog(description = "添加标签")
    @ApiOperation("添加标签")
    public Response addTag(@RequestBody @Validated AddTagReqVO addTagReqVO) {
        return adminTagService.addTag(addTagReqVO);
    }

    @PostMapping("/list")
    @ApiOperationLog(description = "标签分页数据获取")
    @ApiOperation("标签分页数据获取")
    public PageResponse findTagPageList(@RequestBody @Validated FindTagPageListReqVO findCategoryPageListReqVO) {
        return adminTagService.findTagPageList(findCategoryPageListReqVO);
    }

    @PostMapping("/delete")
    @ApiOperationLog(description = "删除标签")
    @ApiOperation("删除标签")
    public Response deleteTag(@RequestBody @Validated DeleteTagReqVO deleteCategoryReqVO) {
        return adminTagService.deleteTag(deleteCategoryReqVO);
    }

    @PostMapping("/search")
    @ApiOperationLog(description = "标签模糊查询")
    @ApiOperation("标签模糊查询")
    public Response searchTag(@RequestBody @Validated SearchTagReqVO searchTagReqVO) {
        return adminTagService.searchTag(searchTagReqVO);
    }

    @PostMapping("/select/list")
    @ApiOperationLog(description = "查询标签 Select 列表数据")
    @ApiOperation("查询标签 Select 列表数据")
    public Response findTagSelectList() {
        return adminTagService.findTagSelectList();
    }
}
