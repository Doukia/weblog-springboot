package com.zsk.weblog.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 朱少康
 * @date 2024/7/16
 **/
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}