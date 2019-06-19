package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:07
 * @description: TODO
 */

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class ExceptionTest3 {
    //把uncheck异常转换为check异常
    public static void cal() throws FirstException {
        try {
            int k = 10/0;
        }catch (ArithmeticException e){
            throw new FirstException("除数不能为0");
        }
    }

    //把check异常转换为uncheck异常
    public static void change(){
        try {
            Class clz = Class.forName("com.briup.exception");
            System.out.println("clz="+clz);
        }catch (ClassNotFoundException e){
            throw new SecondException("类名不存在");
        }
    }

    public static void main(String[] args) {
        System.out.println("-----start------");
        try {
            cal();
        }catch (FirstException e){
            System.out.println(e.getMessage());
        }
        try {
            change();
        }catch (SecondException e){
            System.out.println(e.getMessage());
        }
        System.out.println("------end-------");
    }
}
