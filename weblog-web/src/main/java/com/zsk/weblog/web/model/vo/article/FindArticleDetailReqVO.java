package com.zsk.weblog.web.model.vo.article;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱少康
 * @date 2024/7/27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("查询文章详情 VO")
public class FindArticleDetailReqVO {
    /**
     * 文章 ID
     */
    private Long articleId;
}
