package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:01
 * @description: 自定义check异常
 */

public class FirstException extends Exception{
    public FirstException(){
        super();
    }

    public FirstException(String message){
        super(message);
    }

    public FirstException(Throwable cause){
        super(cause);
    }

    public FirstException(String message,Throwable cause){
        super(message,cause);
    }
}
