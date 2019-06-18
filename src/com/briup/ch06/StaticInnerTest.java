/**
 * @author xuchunlin
 * @time 2019年6月12日上午11:21:04
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class StaticInnerTest {
	private int age=20;
	private static int count=99;
	
	public void print() {
		System.out.println(age);
		System.out.println(StaticInner.num);
		System.out.println(new StaticInner().age);
	}
	
	//静态内部类
	public static class StaticInner{
		private int age = 10;
		private static int num =100;
		public StaticInner() {
			
		}
		public void print() {
			System.out.println(StaticInnerTest.count);
			System.out.println(age);
			//静态内部类不会自动持有外围类对象
			System.out.println(new StaticInnerTest().age);
		}
		public static void test() {
			
		}
	}
}

