package com.briup.enums;
/* *
 *@author:xuchunlin
 *@createTime:2019/6/18/11:58
 */

public enum Season {
    //调用的是无参构造器
    spring,summer,autumn,winter;

    //变量和方法的定义要放在枚举的后面
    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static void main(String[] args) {
        Season s = Season.spring;
        s.setDay(120);
        System.out.println(s+"有"+s.getDay()+"天");
    }
}
