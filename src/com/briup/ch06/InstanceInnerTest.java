/**
 * @author xuchunlin
 * @time 2019年6月12日上午10:31:40
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class InstanceInnerTest {
	private int age=10;
	private int a = 100;
	private static int num = 99;
	
	public void print() {
		System.out.println(new InstanceInner().name);
	}
	
	//实例内部类,自动持有外围类对象
	public class InstanceInner{
		private int age=20;
		
		private String name = "briup";
		//不能有静态变量
		/*private static int num;*/
		public InstanceInner() {
			
		}
		public void print() {
			//就近原则
			System.out.println(age);
			System.out.println(a);
			//访问外围类资源
			System.out.println(InstanceInnerTest.this.age);
			System.out.println(InstanceInnerTest.num);
		}
		//不能有静态方法
		/*	public static void test() {
				
			}*/
	}
}

