package com.zsk.weblog.admin.convert;

import com.zsk.weblog.admin.model.vo.article.FindArticleDetailRspVO;
import com.zsk.weblog.common.domain.dos.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 朱少康
 * @date 2024/7/24
 **/
@Mapper
public interface ArticleDetailConvert {

    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);
}
