/**
 * @author xuchunlin
 * @time 2019年6月4日下午4:18:52
 * @version
 * @description TODO
 */
package com.briup.ch04;


public class ArrayTest4 {
	public static void main(String[] args) {
		String[] numbers = {"18879701234",
				"18879701245",
				"18879704567",
				"18879707890"
		};
		String number = getPhone(numbers);
		System.out.println(number);
		getCode();
	};

	//抽奖
	public static String getPhone(String[] numbers) {
		//随机产生一个下标[0,length-1]
		int index = (int)(Math.random()*numbers.length);
		return numbers[index];
	}
	//随机生成4位验证码
	public static void getCode() {
		String str = "qwertyuiopasdfghjklzxcvbnm"
				+ "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
		char[] code = str.toCharArray();
		for(int i=0;i<4;i++) {
			int index = (int)(Math.random()*code.length);
			char temp = code[index];
			System.out.print(temp);
		}
		System.out.println();
	}
}

