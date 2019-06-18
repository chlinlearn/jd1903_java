package com.briup.ch03;

public class SwitchTest{
	public static void main(String[] args){
		//switch 后面的变量数据类型只能是：byte,char,short,int,
		//1.8版本支持 String,1.5版本支持 枚举
		char a = 'c';
		switch(a){
			case 'a':
				System.out.print("A");
				break;
			case 'c':
				System.out.print("C");
				break;
			default:
				System.out.print("Other");
				break;
		}
	}
}