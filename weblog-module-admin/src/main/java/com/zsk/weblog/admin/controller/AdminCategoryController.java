package com.zsk.weblog.admin.controller;

import com.zsk.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.zsk.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.zsk.weblog.admin.service.AdminCategoryService;
import com.zsk.weblog.common.aspect.ApiOperationLog;
import com.zsk.weblog.common.utils.PageResponse;
import com.zsk.weblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/admin/category")
@Api(tags = "Admin 分类模块")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService adminCategoryService;

    @PostMapping("/add")
    @ApiOperationLog(description = "添加分类")
    @ApiOperation("添加分类")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return adminCategoryService.addCategory(addCategoryReqVO);
    }

    @PostMapping("/list")
    @ApiOperationLog(description = "分类分页数据获取")
    @ApiOperation("分类分页数据获取")
    public PageResponse findCategoryPageList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
        return adminCategoryService.findCategoryPageList(findCategoryPageListReqVO);
    }

    @PostMapping("/delete")
    @ApiOperationLog(description = "删除分类")
    @ApiOperation("删除分类")
    public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
        return adminCategoryService.deleteCategory(deleteCategoryReqVO);
    }

    @PostMapping("/select/list")
    @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
    @ApiOperation("分类 Select 下拉列表数据获取")
    public Response findCategorySelectList() {
        return adminCategoryService.findCategorySelectList();
    }
}
