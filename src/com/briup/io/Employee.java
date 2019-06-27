package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/14:33
 * @description: 以属性为主的员工类
 */

import java.io.Serializable;

public class Employee implements Serializable {
    private final static long serialVersionUID = 1L;
    private String name;
    private double salary;//transient关键字，使得该属性透明化，不被序列化和反序列化
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
