package com.zsk.weblog.admin.model.vo.tag;

import com.zsk.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author 朱少康
 * @date 2024/7/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("查询标签分页数据入参 VO")
public class FindTagPageListReqVO extends BasePageQuery {
    /**
     * 标签名称
     */
    private String name;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
