package com.briup.jdk8.day2;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/4/14:44
 * @description: null
 */

import java.util.function.Function;

public class Test03_Function {
    public static void main(String[] args) {
        Function<String,Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        int n = f.apply("123");
        System.out.println(n);

        Function<Integer,String> f2 = Integer::toBinaryString;
                //num->Integer.toBinaryString(num);
        String str = f2.apply(12);
        System.out.println(str);

        Function<Model,String> f3 = Model::getName;
        Function<String,Model> f4 = Model::new;
        Model model = f4.apply("lucy");
        String name = f3.apply(model);
        System.out.println(name);

        //String "10" --> Integer -->Model
        System.out.println("------------");
        Function<String,Integer> f5 = Integer::parseInt;
        Function<Integer,Model> f6 = age->new Model(age);
        //Function<Model,String> f7 = f5.andThen(f6);
    }
}
