package com.zsk.weblog.web.model.vo.archive;

import com.zsk.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author 朱少康
 * @date 2024/7/26
 **/
@Data
@Builder
@ApiModel("文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}
