package com.zsk.weblog.admin.service;

import com.zsk.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.zsk.weblog.common.utils.Response;

/**
 * @author 朱少康
 * @date 2024/7/23
 **/
public interface AdminBlogSettingsService {

    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);

    /**
     * 获取博客设置详情
     * @return
     */
    Response findDetail();
}
