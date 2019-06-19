package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:23
 * @description: test assert（断言）,断言默认关闭,-ea打开
 */

import java.sql.SQLOutput;

public class AssertTest {
    public static void main(String[] args) {
        System.out.println("start----------");
        int b=4;
        int a=3;
        assert a>b:"error a小于等于b";
        System.out.println("briup----------");
        System.out.println("end------------");
    }
}
