package com.zsk.weblog.web.service.impl;

import com.zsk.weblog.common.domain.dos.ArticleDO;
import com.zsk.weblog.common.domain.mapper.ArticleMapper;
import com.zsk.weblog.common.domain.mapper.CategoryMapper;
import com.zsk.weblog.common.domain.mapper.TagMapper;
import com.zsk.weblog.common.utils.Response;
import com.zsk.weblog.web.model.vo.statistics.FindStatisticsInfoRspVO;
import com.zsk.weblog.web.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 朱少康
 * @date 2024/8/7
 **/
@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    /**
     * 获取文章总数、分类总数、标签总数、总访问量统计信息
     *
     * @return
     */
    @Override
    public Response findInfo() {
        // 查询文章总数
        Long articleTotalCount = articleMapper.selectCount(null);

        // 查询分类总数
        Long categoryTotalCount = categoryMapper.selectCount(null);

        // 查询标签总数
        Long tagTotalCount = tagMapper.selectCount(null);

        // 总浏览量
        List<ArticleDO> articleDOS = articleMapper.selectAllReadNum();
        Long pvTotalCount = 0L;

        if (!CollectionUtils.isEmpty(articleDOS)) {
            // 所有 read_num 相加
            pvTotalCount = articleDOS.stream().mapToLong(ArticleDO::getReadNum).sum();
        }

        // 组装 VO 类
        FindStatisticsInfoRspVO vos = FindStatisticsInfoRspVO.builder()
                .articleTotalCount(articleTotalCount)
                .categoryTotalCount(categoryTotalCount)
                .pvTotalCount(pvTotalCount)
                .tagTotalCount(tagTotalCount)
                .build();


        return Response.success(vos);
    }
}
