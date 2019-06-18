/**
 * @author xuchunlin
 * @time 2019年6月5日上午10:31:51
 * @version
 * @description TODO
 */
package com.briup.ch04;

public class VarArgsTest {
	//可变长参数必须放在后面
	public static int add(String str,int... array) {
		int sum = 0;
		/*
		 * for (int i = 0; i < array.length; i++) { sum += array[i]; }
		 */
		//增强for循环
		for(int temp:array) {
			sum += temp;
		}
		return sum;
	}
	public static void main(String[] args) {
		int sum = add("abc",4,6);
		System.out.println(sum);
	}
}

