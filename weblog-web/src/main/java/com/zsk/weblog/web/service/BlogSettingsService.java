package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
public interface BlogSettingsService {

    /**
     * 获取博客设置信息
     * @return
     */
    Response findDetail();
}
