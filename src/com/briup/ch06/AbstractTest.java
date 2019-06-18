/**
 * @author xuchunlin
 * @time 2019年6月11日上午10:23:15
 * @version
 * @description TODO
 */
package com.briup.ch06;

public abstract class AbstractTest {
	public void print() {
		System.err.println("print...");
	}
	
	//抽象方法,一个类中如果含有抽象方法，那么这个类必须是抽象类；
	//抽象类中不一定有抽象方法；
	public abstract void print2();
	
	public static void main(String[] args) {
		//失去创建对象的能力
		//AbstractTest t = new AbstractTest();
	}
	
}

abstract class Test{
	//抽象类可以有普通方法
	public void print() {
		
	}
	//抽象类可以有构造方法
	public Test() {
		
	}
	//不一定有抽象方法
}

class Main extends AbstractTest{
 
	@Override
	public void print2() {
		// TODO Auto-generated method stub
		System.out.println("print2...");
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.print2();
		m.print();
	}
}

