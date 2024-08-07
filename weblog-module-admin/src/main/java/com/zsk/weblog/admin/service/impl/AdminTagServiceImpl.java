package com.zsk.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsk.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.zsk.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.zsk.weblog.admin.model.vo.category.FindCategoryPageListRspVO;
import com.zsk.weblog.admin.model.vo.tag.*;
import com.zsk.weblog.admin.service.AdminCategoryService;
import com.zsk.weblog.admin.service.AdminTagService;
import com.zsk.weblog.common.domain.dos.ArticleTagRelDO;
import com.zsk.weblog.common.domain.dos.CategoryDO;
import com.zsk.weblog.common.domain.dos.TagDO;
import com.zsk.weblog.common.domain.mapper.ArticleTagRelMapper;
import com.zsk.weblog.common.domain.mapper.CategoryMapper;
import com.zsk.weblog.common.domain.mapper.TagMapper;
import com.zsk.weblog.common.enums.ResponseCodeEnum;
import com.zsk.weblog.common.exception.BizException;
import com.zsk.weblog.common.model.SelectRspVO;
import com.zsk.weblog.common.utils.PageResponse;
import com.zsk.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 朱少康
 * @date 2024/7/20
 **/
@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;


    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    @Override
    public Response addTag(AddTagReqVO addTagReqVO) {
        // VO 转 DO
        List<TagDO> tagDOS = addTagReqVO.getTags()
                .stream()
                .map(tagName -> TagDO.builder()
                        .name(tagName.trim()) // 去掉前后空格
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());

        // 批量插入
        try {
            saveBatch(tagDOS);
        } catch (Exception e) {
           log.warn("该标签已存在",e);
        }


        return Response.success();
    }

    /**
     * 查询标签分页
     *
     * @param findCategoryPageListReqVO
     * @return
     */
    @Override
    public PageResponse findTagPageList(FindTagPageListReqVO findCategoryPageListReqVO) {
        Long current = findCategoryPageListReqVO.getCurrent();
        Long size = findCategoryPageListReqVO.getSize();
        String name = findCategoryPageListReqVO.getName();
        LocalDate startDate = findCategoryPageListReqVO.getStartDate();
        LocalDate endDate = findCategoryPageListReqVO.getEndDate();


        Page<TagDO> tagDOPage = tagMapper.selectPageList(current, size, name, startDate, endDate);

        List<TagDO> tagDOS = tagDOPage.getRecords();

        // DO 转 VO
        List<FindTagPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> FindTagPageListRspVO.builder()
                            .id(tagDO.getId())
                            .name(tagDO.getName())
                            .createTime(tagDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(tagDOPage,vos);
    }

    /**
     * 删除标签
     *
     * @param deleteTagReqVO
     * @return
     */
    @Override
    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        // 标签 ID
        Long tagId = deleteTagReqVO.getId();

        // 校验该标签下是否有关联的文章，若有，则不允许删除，提示用户需要先删除标签下的文章
        ArticleTagRelDO articleTagRelDO = articleTagRelMapper.selectOneByTagId(tagId);

        if (Objects.nonNull(articleTagRelDO)) {
            log.warn("==> 此标签下包含文章，无法删除，tagId: {}", tagId);
            throw new BizException(ResponseCodeEnum.TAG_CAN_NOT_DELETE);
        }

        // 根据标签 ID 删除
        int count = tagMapper.deleteById(tagId);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.TAG_NOT_EXISTED);
    }

    /**
     * 根据标签关键词模糊查询
     *
     * @param searchTagReqVO
     * @return
     */
    @Override
    public Response searchTag(SearchTagReqVO searchTagReqVO) {
        String key = searchTagReqVO.getKey();

        List<TagDO> tagDOS = tagMapper.selectByKey(key);

        // DO 转 VO
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }

    /**
     * 查询标签 Select 列表数据
     *
     * @return
     */
    @Override
    public Response findTagSelectList() {
        // 查询所有标签
        List<TagDO> tagDOS = tagMapper.selectList(null);

        // DO 转 VO
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }


}
