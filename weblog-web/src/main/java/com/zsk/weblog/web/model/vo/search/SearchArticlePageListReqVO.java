package com.zsk.weblog.web.model.vo.search;

import com.zsk.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author 朱少康
 * @date 2024/8/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("文章搜索 VO")
public class SearchArticlePageListReqVO extends BasePageQuery {
    /**
     * 查询关键词
     */
    @NotBlank(message = "搜索关键词不能为空")
    private String word;
}
