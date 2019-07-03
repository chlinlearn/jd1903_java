package com.briup.annotation;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/1/11:11
 * @description: 测试自定义注解
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@FirstAnnotation()
public class Test {
    @FirstAnnotation
    private int age;

    @FirstAnnotation
    public void print(@FirstAnnotation String name){
        @FirstAnnotation
        int num;
    }

    @SecondAnnotation(age = 18,name = "tom",value = "hello")
    public void test(){

    }

    public static void main(String[] args) throws Exception{
        int age;
        String name;
        //只能通过反射获取注解信息,而且注解保留的时间不一样,反射是在运行时才拿到Class
        Method method = Class.forName("com.briup.annotation.Test")
                .getMethod("test");
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation:annotations){
            System.out.println(annotation);
            if (annotation instanceof SecondAnnotation){
                age = ((SecondAnnotation) annotation).age();
                name = ((SecondAnnotation) annotation).name();
                System.out.println(age+"-"+name);
            }
        }
    }
}
