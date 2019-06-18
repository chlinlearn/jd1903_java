package com.briup.enums;
/* *
 *@author:xuchunlin
 *@createTime:2019/6/18/14:07
 */

public enum Method {
    Add{
        public int cal(int a,int b){
            return a+b;
        }
    },Minus{
        public int cal(int a,int b){
            return a-b;
        }
    },Multiply{
        public int cal(int a,int b){
            return a*b;
        }
    },Div{
        public int cal(int a,int b){
            return a/b;
        }
    };
    public abstract int cal(int a,int b);

    public static void main(String[] args) {
        Method m1=Method.Add;
        System.out.println(m1.cal(10,2));
        Method m2=Method.Minus;
        System.out.println(m2.cal(10,2));
    }
}
