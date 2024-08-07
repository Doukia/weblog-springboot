package com.zsk.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 朱少康
 * @date 2024/7/16
 **/
@Getter
@Setter
public class BizException extends RuntimeException{
    //异常码
    private String errorCode;
    //异常信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
