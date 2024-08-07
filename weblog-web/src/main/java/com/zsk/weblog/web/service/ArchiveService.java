package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.archive.FindArchiveArticlePageListReqVO;

/**
 * @author 朱少康
 * @date 2024/7/26
 **/
public interface ArchiveService {

    /**
     * 获取文章归档分页数据
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO);
}
