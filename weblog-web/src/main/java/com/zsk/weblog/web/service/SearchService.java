package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.search.SearchArticlePageListReqVO;

/**
 * @author 朱少康
 * @date 2024/8/8
 **/
public interface SearchService {

    /**
     * 关键词分页搜索
     * @param searchArticlePageListReqVO
     * @return
     */
    Response searchArticlePageList(SearchArticlePageListReqVO searchArticlePageListReqVO);
}