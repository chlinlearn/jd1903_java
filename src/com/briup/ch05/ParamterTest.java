/**
 * @author xuchunlin
 * @time 2019年6月6日上午9:44:48
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class ParamterTest {
	public static void main(String[] args) {
		int i = 10;
		System.out.println("before:"+i);
		increment(i);
		System.out.println("after:"+i);
	}
	
	public static void increment(int i) {
		++i;
		System.err.println("increment:"+i);
	}
}

