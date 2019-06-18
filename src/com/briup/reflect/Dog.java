package com.briup.reflect;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/9:58
 * @description: TODO
 */

public class Dog {
    private String name;
    private int age;

    /*public Dog(){
        age = 1;
    }*/
    public Dog(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print(){
        System.out.println("狗的名字："+name+",狗的年龄："+age);
    }

    public static String test(int i,String s){
        return i+s;
    }

}
