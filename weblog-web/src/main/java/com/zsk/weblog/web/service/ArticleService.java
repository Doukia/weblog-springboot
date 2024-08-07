package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.article.FindArticleDetailReqVO;
import com.zsk.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/

public interface ArticleService {

    /**
     * 获取首页文分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);

    /**
     * 获取文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);
}
