package com.zsk.weblog.admin.controller;

import com.zsk.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.zsk.weblog.admin.service.AdminUserService;
import com.zsk.weblog.common.aspect.ApiOperationLog;
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
 * @date 2024/7/19
 **/
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 用户模块")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改用户密码")
    @ApiOperation("修改用户密码")
    public Response updatePassword(@RequestBody @Validated UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        return adminUserService.updatePassword(updateAdminUserPasswordReqVO);
    }

    @PostMapping("/user/info")
    @ApiOperationLog(description = "获取用户信息")
    @ApiOperation("获取用户信息")
    public Response findUserInfo() {
        return adminUserService.findUserInfo();
    }
}
