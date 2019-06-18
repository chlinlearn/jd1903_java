/**
 * @author xuchunlin
 * @time 2019年6月12日上午11:47:48
 * @version
 * @description TODO
 */
package com.briup.ch06;

interface Fruit{
	public void eat();
}

public class AnonymousInnerTest {
	public static void print(Fruit fruit) {
		fruit.eat();
	}
	
	public static void main(String[] args) {
		//创建匿名内部类
		print(new Fruit() {
			
			@Override
			public void eat() {
				System.out.println("eat...");
			}
		});
	}
}

