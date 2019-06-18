/**
 * @author xuchunlin
 * @time 2019年6月11日上午11:40:35
 * @version
 * @description TODO
 */
package com.briup.ch06;

//测试接口
interface Animal{
	//接口中的变量默认都是public,static,final修饰
	int n = 10;
	public int age = 10;
	public static int num =10;
	//没有构造器
	//public Animal() {}
	
	//接口的方法默认是abstract
	public void print();
	
	void test();
	
	//失创建对象能力
}

interface Food{
	
}

//接口可以继承接口,可以是继承多个
interface Fish extends Animal,Food{
	void eat();
}

//类可以实现多个接口
class shark implements Fish,Food{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	
}

//类可以实现接口
class Dog implements Animal{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceTest{
	public static void main(String[] args) {
		Animal a = new Dog();
		a.print();
	}
}

