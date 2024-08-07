package com.zsk.weblog.common.exception;

/**
 * @author 朱少康
 * @date 2024/7/16
 * @description: 通用异常接口
 **/
public interface BaseExceptionInterface {
    String getErrorCode();

    String getErrorMessage();
}
