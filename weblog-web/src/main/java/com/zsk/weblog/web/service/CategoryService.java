package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
public interface CategoryService {

    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList();

    /**
     * 获取分类下文章分页数据
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}