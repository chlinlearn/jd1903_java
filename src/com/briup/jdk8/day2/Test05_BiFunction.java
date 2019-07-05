package com.briup.jdk8.day2;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/4/15:18
 * @description: null
 */

import java.util.function.BiFunction;

public class Test05_BiFunction {
    public static void main(String[] args) {
        BiFunction<String,Integer,Model> bf =
                new BiFunction<String, Integer, Model>() {
            @Override
            public Model apply(String s, Integer integer) {
                return new Model(s,integer);
            }
        };

        Model m = bf.apply("briup",20);
        System.out.println(m.getName()+"-"+m.getAge());

        System.out.println("----------");
        BiFunction<String,Integer,Model> bf2 = Model::new;
        Model m1 = bf2.apply("xcl",21);
        System.out.println(m1.getName()+"-"+m1.getAge());

    }
}
