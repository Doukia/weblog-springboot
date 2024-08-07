package com.zsk.weblog.common.aspect;

import java.lang.annotation.*;

/**
 * @author 朱少康
 * @date 2024/7/15
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
