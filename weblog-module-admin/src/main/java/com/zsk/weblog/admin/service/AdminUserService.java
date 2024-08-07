package com.zsk.weblog.admin.service;

import com.zsk.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.zsk.weblog.common.utils.Response;

/**
 * @author 朱少康
 * @date 2024/7/19
 **/
public interface AdminUserService {

    /**
     * 修改密码
     *
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    Response findUserInfo();
}
