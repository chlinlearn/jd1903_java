package com.briup.jdk8.day2;

public class Model{
    private String name;
    private int age;

    public Model(){
        System.out.println("jack");
    };

    public Model(String name){
        this.name = name;
        System.out.println(name);
    }
    public Model(int age){
        this.age = age;
    }

    public Model(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test1() {
        System.out.println("test1");
    }
    public void test2(String s) {
        System.out.println("test2");
    }
    public int test3() {
        System.out.print("test3....");
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}