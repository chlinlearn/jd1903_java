package com.briup.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecondAnnotation {
    //如何在注解()中添加参数
    int age() default 10;//成员变量，变量名是方法名，变量值的类型是方法的返回值类型
    String name() default "jack";
    String value();//属性有且只有一个属性时，使用注解可以不加变量名,直接写变量值
}
