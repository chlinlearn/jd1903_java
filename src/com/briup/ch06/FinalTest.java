/**
 * @author xuchunlin
 * @time 2019年6月11日上午10:08:47
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class FinalTest {
	private final int age;
	private final static int num;
	
	static {
		num = 10;
	}
	
	{
		age = 0;
	}
	
	//不能在这里赋值
	//age = 0;
	
	public FinalTest() {
		//age = 0;
		//num = 2;
	}
	
	public void test() {
		final String name = "hello";
	}
	
	public static void main(String[] args) {
		
	}

}

