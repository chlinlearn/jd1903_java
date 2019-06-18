package com.briup.enums;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/14:32
 * @description: TODO
 */
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumSetTest {
    public static void main(String[] args) {
        //EnumSet测试
        EnumSet<Month> set = EnumSet.allOf(Month.class);
        System.out.println(set);
        EnumSet<Month> set1 = EnumSet.noneOf(Month.class);
        System.out.println(set1);
        set1.add(Month.AGU);
        System.out.println(set1);
        EnumSet<Month> set2 = EnumSet.of(Month.APR,Month.DEC);
        System.out.println(set2);
        //不包含set2中的元素
        EnumSet<Month> set3 = EnumSet.complementOf(set2);
        System.out.println(set3);
        //EnumMap测试
        System.out.println("------EnumMap-------");
        EnumMap<Month,String> map = new EnumMap<Month, String>(Month.class);
        map.put(Month.AGU,"一月");
        System.out.println(map);
    }
}
