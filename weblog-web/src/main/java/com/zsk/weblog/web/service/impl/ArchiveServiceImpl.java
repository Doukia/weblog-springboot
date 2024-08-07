package com.zsk.weblog.web.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsk.weblog.common.domain.dos.ArticleDO;
import com.zsk.weblog.common.domain.mapper.ArticleMapper;
import com.zsk.weblog.common.utils.PageResponse;
import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.convert.ArticleConvert;
import com.zsk.weblog.web.model.vo.archive.FindArchiveArticlePageListReqVO;
import com.zsk.weblog.web.model.vo.archive.FindArchiveArticlePageListRspVO;
import com.zsk.weblog.web.model.vo.archive.FindArchiveArticleRspVO;
import com.zsk.weblog.web.service.ArchiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 朱少康
 * @date 2024/7/26
 **/
@Service
@Slf4j
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取文章归档分页数据
     *
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    @Override
    public Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO) {
        Long current = findArchiveArticlePageListReqVO.getCurrent();
        Long size = findArchiveArticlePageListReqVO.getSize();

        // 分页查询
        Page<ArticleDO> page = articleMapper.selectPageList(current, size, null, null, null);
        List<ArticleDO> articleDOS  = page.getRecords();

        ArrayList<FindArchiveArticlePageListRspVO> vos = new ArrayList<>();

        if (!CollectionUtils.isEmpty(articleDOS )) {
            // DO 转 VO
            List<FindArchiveArticleRspVO> archiveArticleRspVOS =  articleDOS.stream()
                    .map(articleDO -> ArticleConvert.INSTANCE.convertDO2ArchiveArticleVO(articleDO))
                    .collect(Collectors.toList());

            // 按创建的月份进行分组
            Map<YearMonth, List<FindArchiveArticleRspVO>> map = archiveArticleRspVOS.stream().collect(Collectors.groupingBy(FindArchiveArticleRspVO::getCreateMonth));
            // 使用 TreeMap 按月份倒序排列
            Map<YearMonth, List<FindArchiveArticleRspVO>> sortedMap = new TreeMap<>(Collections.reverseOrder());
            sortedMap.putAll(map);

            // 遍历排序后的 Map，将其转换为归档 VO
            sortedMap.forEach((k, v) -> vos.add(FindArchiveArticlePageListRspVO.builder().month(k).articles(v).build()));
        }

        return PageResponse.success(page, vos);
    }
}