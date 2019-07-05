package com.briup.jdk8.day2;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/4/15:06
 * @description: null
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Test04_BinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<String> bo = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s+s2;
            }
        };
        String str = bo.apply("hello","world");
        System.out.println(str);

        System.out.println("-------------");
        /*BinaryOperator.minBy(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });*/
        BinaryOperator<Integer> b = BinaryOperator.minBy(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int min = b.apply(12,6);
        System.out.println(min);

        //BinaryOperator<Integer> b1 = (i1,i2)->i1-i2;
        BinaryOperator<Integer> b1 = BinaryOperator.minBy((i1,i2)->i1-i2);
        int no = b.apply(13,12);
        System.out.println(no);
    }
}

