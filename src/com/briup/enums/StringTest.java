package com.briup.enums;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/15:06
 * @description: TODO
 */

public class StringTest {
    public static void main(String[] args) {
        String s1 = "";
        long start = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            s1+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String花费的时间："+(end-start));

        StringBuffer sb = new StringBuffer("");
        start = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer花费的时间："+(end-start));
    }
}
