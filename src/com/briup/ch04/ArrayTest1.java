/**
 * @author xuchunlin
 * @time 2019年6月4日下午2:28:25
 * @version
 * @description TODO
 */
package com.briup.ch04;

public class ArrayTest1 {
	public static void main(String[] args) {
		//1)申明数组
		int[] array;
		//2)创建数组对象（通过new）
		array = new int[10];
		//3)给数组的元素赋值
		array[0] = 12;
		array[1] = 16;
		//4)遍历数组元素并输出
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}

