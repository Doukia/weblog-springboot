package com.zsk.weblog.web.service;

import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.tag.FindTagArticlePageListReqVO;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
public interface TagService {

    /**
     * 获取标签列表
     * @return
     */
    Response findTagList();

    /**
     * 获取标签下文章分页列表
     * @param findTagArticlePageListReqVO
     * @return
     */
    Response findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);
}
