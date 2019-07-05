package com.briup.jdk8.day2;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/4/14:22
 * @description: 生成者
 */

import java.util.function.Supplier;

public class Test01_Supplier {
    public static void main(String[] args) {
        Supplier<String> s1 = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };

        String str = s1.get();
        System.out.println(str);

        Supplier<String> s2 = ()->"world";
        System.out.println(s2.get());

        Supplier<Model> s3 = Model::new;
        s3.get().test1();
    }
}
