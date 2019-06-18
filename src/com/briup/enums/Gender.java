package com.briup.enums;
/* *
 *@author:xuchunlin
 *@createTime:2019/6/18/11:41
 */

//枚举类
public enum Gender {
    //枚举值
    //public static final Gender Male = new Gender();
    Male,Female;

    public static void main(String[] args) {
        System.out.println(Gender.Male);
        System.out.println(Gender.Female);

        Gender[] g = Gender.values();
        for (Gender gender:g){
            System.out.println(gender);
        }

        Gender g1 = Gender.valueOf("Male");
        System.out.println(g1);
    }
}
