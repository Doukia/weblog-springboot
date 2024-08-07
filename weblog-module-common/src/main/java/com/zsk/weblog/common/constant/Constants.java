package com.zsk.weblog.common.constant;

import java.time.format.DateTimeFormatter;

/**
 * @author 朱少康
 * @date 2024/7/29
 **/
public interface Constants {
    /**
     * 月-日 格式
     */
    DateTimeFormatter MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern("MM-dd");
}
