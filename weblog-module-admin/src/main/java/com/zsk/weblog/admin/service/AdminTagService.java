package com.zsk.weblog.admin.service;

import com.zsk.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.zsk.weblog.admin.model.vo.tag.AddTagReqVO;
import com.zsk.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.zsk.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.zsk.weblog.admin.model.vo.tag.SearchTagReqVO;
import com.zsk.weblog.common.utils.PageResponse;
import com.zsk.weblog.common.utils.Response;

/**
 * @author 朱少康
 * @date 2024/7/20
 **/
public interface AdminTagService {

    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    Response addTag(AddTagReqVO addTagReqVO);

    /**
     * 查询标签分页
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findTagPageList(FindTagPageListReqVO findCategoryPageListReqVO);

    /**
     * 删除标签
     * @param deleteCategoryReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteCategoryReqVO);

    /**
     * 根据标签关键词模糊查询
     * @param searchTagReqVO
     * @return
     */
    Response searchTag(SearchTagReqVO searchTagReqVO);

    /**
     * 查询标签 Select 列表数据
     * @return
     */
    Response findTagSelectList();
}
