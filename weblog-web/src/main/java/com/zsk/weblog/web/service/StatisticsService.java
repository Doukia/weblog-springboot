package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;

/**
 * @author 朱少康
 * @date 2024/8/7
 **/
public interface StatisticsService {

    /**
     * 获取文章总数、分类总数、标签总数、总访问量统计信息
     *
     * @return
     */
    Response findInfo();
}
