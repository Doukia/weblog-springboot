package com.zsk.weblog.web.model.vo.article;

import com.zsk.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
@Data
@Builder
@ApiModel("首页查询文章分页 VO")
public class FindIndexArticlePageListReqVO extends BasePageQuery {
}
