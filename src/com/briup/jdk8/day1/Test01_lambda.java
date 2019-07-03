package com.briup.jdk8.day1;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/9:10
 * @description: lambda表达式
 */

@FunctionalInterface
interface Tool{
    //public void tool();
    public int tool(String s);

    //扩种方法
    default double sqrt(int a){
        return Math.sqrt(a);
    }

    public static String sayHello(String name) {
        return "hello " + name;
    }
}

public class Test01_lambda {
    public static void main(String[] args) {
        /*Tool t = new Tool() {
            @Override
            public void tool() {
                System.out.println("tool()....");
            }
        };
        t.tool();*/

        /*Tool t1 = ()->{
            System.out.println("lambda....");
        };
        t1.tool();*/

        /*Tool t2 = s-> System.out.println(s);
        t2.tool("hello");*/

        Tool t2 = String::length;
        int n = t2.tool("hello");
        String str = Tool.sayHello("tom");
        System.out.println(str);
        System.out.println(n);
    }
}
