package com.briup.jdk8.day1;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/2/14:21
 * @description: jdk8中接口可以添加非抽象方法（包含方法体）
 */

public class Test01_Interface {
    public static void main(String[] args) {
        Inter inter = new Inter() {
            @Override
            public void disp1() {
                System.out.println("disp1...");
            }

            @Override
            public void disp2() {
                System.out.println("disp2...");
            }
        };

        inter.disp1();
        inter.disp2();
        inter.show();
        Inter.outInter();
    }
}

interface Inter{
    //定义一个成员
    public static final int num = 10;
    //private static final int num1=20;
    int num2 = 20;

    //抽象方法
    void disp1();
    public abstract void disp2();

    //jdk8新特性1
    //接口中可以定义非抽象方法,前提，default关键字修饰,称为扩展方法
    public default void show(){
        System.out.println("in Inter,show()");
    }

    //jdk8新特性2
    //在接口中定义静态方法,不能通过实现类对象访问,只能通过接口来引用s
    public static void outInter(){
        System.out.println("int static outInter...");
    }

}