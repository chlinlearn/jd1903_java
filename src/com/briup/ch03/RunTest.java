package com.briup.ch03;

public class RunTest{
	//使用main参数接受外界终端输入数据
	public static void main(String[] args){
		//取出数组中的第一个元素并转换为Integer
		Integer year = Integer.parseInt(args[0]);
		if(year%400==0 || (year%100!=0&year%4==0)){
			System.out.print(year+"是闰年");
		}else{
			System.out.print(year+"不是闰年");
		}
	}
}