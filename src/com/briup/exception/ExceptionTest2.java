package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/10:23
 * @description: TODO
 */

public class ExceptionTest2 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        //运行时异常
        //int k = 10/0;
        //非运行时异常
        try {
            Class.forName("com.briup.exception.ExceptionTest3");
        } catch (ClassNotFoundException e) {
            System.out.println("该类不存在");
        }
    }
}
