package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:05
 * @description: 自定义uncheck异常
 */

public class SecondException extends RuntimeException{
    public SecondException() {
    }

    public SecondException(String message) {
        super(message);
    }

    public SecondException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecondException(Throwable cause) {
        super(cause);
    }

}
