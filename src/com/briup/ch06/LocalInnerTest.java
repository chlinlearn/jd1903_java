/**
 * @author xuchunlin
 * @time 2019年6月12日上午11:36:17
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class LocalInnerTest {
	private int age =10;
	private static int num=100;
	public void print() {
		int a = 5;
		//局部内部类
		class LocalInner{
			private int age =20;
			//private static int num;
			public LocalInner() {
				
			}
			public void print() {
				System.out.println(a);
				System.out.println(age);
				System.out.println(LocalInnerTest.this.age);
				System.out.println(LocalInnerTest.num);
			}
		}
		LocalInner li = new LocalInner();
		li.print();
	}
}

