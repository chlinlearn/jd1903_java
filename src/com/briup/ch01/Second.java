package com.briup.ch01;

import java.util.*;

public class Second{
	
	static int a =0;
	static int b =0;
	
	public static void main(String[] args){
		System.out.println("------------pelase input your option------------");
		System.out.println("(1)add  (2)min  (3)mul  (4)div  (5)exit");
		System.out.println("pelase input number: ");
		Scanner scanner = new Scanner(System.in);
		do{	
			int input=scanner.nextInt();
			if (input==5){
				System.out.println("exit.....");
				break;
			}
			switch(input){
				case 1:	add();
					break;
				case 2:	min();
					break;
				case 3:	mul();
					break;
				case 4:	div();
					break;
				default:
					System.out.println("pelase input currect option！");
					break;
			}
			System.out.print("\n");
			System.out.println("------------pelase input your option------------");
			System.out.println("(1)add (2)min (3)mul (4)div (5)exit");
			System.out.println("pelase input: ");
		}while(true);

	}
	//求和
	static void add(){
		com();
		int c = a+b;
		System.out.println("add: "+c);
	}
	//求差
	static void min(){
		com();
		int c = a-b;
		System.out.println("min: "+c);
	}
	//求积
	static void mul(){
		com();
		int c = a*b;
		System.out.println("mul: "+c);
	}
	//求商
	static void div(){
		com();
		if (b==0){
			System.out.println("zero error......");
		}else{
			int c = a/b;
		System.out.println("div: "+c);
		}		
	}
	//共有部分
	static void com(){
		System.out.println("pelase input two number: ");
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		b = scanner.nextInt();
	}
}