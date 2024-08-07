package com.zsk.weblog.admin.model.vo.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author 朱少康
 * @date 2024/7/19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("修改用户密码 VO")
public class UpdateAdminUserPasswordReqVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
