package com.briup.enums;
/* *
 *@author:xuchunlin
 *@createTime:2019/6/18/12:03
 */

public enum Month {
    //调用的是有参构造器
    JAN(31),FEB(28),MAR(31),APR(30),MAY(31),
    JNU(30),JUL(31),AGU(31),SEP(30),OCT(31),
    NOV(30),DEC(31);

    private int day;

    private Month(int i){
        this.day = i;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static void main(String[] args) {
        Month[] months = Month.values();
        int days = 0;
        for (Month month:months){
            days += month.getDay();
        }
        System.out.println(days);
    }
}
