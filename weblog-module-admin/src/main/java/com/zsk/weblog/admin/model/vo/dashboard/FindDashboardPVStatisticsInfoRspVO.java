package com.zsk.weblog.admin.model.vo.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 朱少康
 * @date 2024/7/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindDashboardPVStatisticsInfoRspVO {
    /**
     * 日期集合
     */
    private List<String> pvDates;

    /**
     * PV 浏览量集合
     */
    private List<Long> pvCounts;
}
