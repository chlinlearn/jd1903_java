/**
 * @author xuchunlin
 * @time 2019年6月11日上午9:20:14
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class StaticTest {
	private int num;
	private static int count;
	//静态初始化块,类加载时调用
	static {
		System.out.println("this static...");
	}
	
	//普通初始化块,每次new都会被调用一次
	{
		System.out.println("nonestatic...");
	}
	
	public StaticTest() {
		num++;
		count++;
	}
	
	public void print() {
		System.out.println("print()....");
	}
	 
	public static void print2() {
		System.out.println("static print2()....");
	}
	

	
	public static void main(String[] args) {
		StaticTest t1 = new StaticTest();
		StaticTest t2 = new StaticTest();
		/*		System.out.println(t1.num);
				System.out.println(t2.num);
				System.out.println(StaticTest.count);
				System.out.println(StaticTest.count);
				new StaticTest().print();
				print2();*/
	}

}

