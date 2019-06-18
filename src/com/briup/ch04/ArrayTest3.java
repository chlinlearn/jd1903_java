/**
 * @author xuchunlin
 * @time 2019年6月4日下午3:14:09
 * @version
 * @description TODO
 */
package com.briup.ch04;

import java.util.Arrays;

public class ArrayTest3 {
	public static void main(String[] args) {
		int[] array = {12,34,55,10,22,18,75,45};
		int sum = getSum(array);
		int max = getMax(array);
		System.out.println("和为："+sum);
		System.out.println("最大值为："+max);
		//int[] arr = sortByBubble(array);
		int[] arr2 = sortBySelect(array);
		print(arr2);
	}
	//求最大值
	public static int getMax(int[] array) {
		int max = array[0];
		for(int i=1;i<array.length;i++) {
			if(max<array[i]) {
				max = array[i];	
			}
		}
		return max;
	}
	//求和
	public static int getSum(int[] array) {
		int sum = 0;
		for(int i=0;i<array.length;i++) {
			sum += array[i];
		}
		return sum;
	}
	//冒泡排序
	public static int[] sortByBubble(int[] array) {
		Arrays.sort(array);
		for (int i = 0; i < array.length-1; i++) {
			boolean flag = false;
			for (int j = 0; j <array.length-i-1; j++) {
				if(array[j]>array[j+1]) {
					flag = true;
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
			if(!flag) {
				break;
			}
		}
		return array;
	}
	//选择排序
	public static int[] sortBySelect(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int k = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[k]>array[j]) {
					k = j;
				}
			}
			//交换数据
			int temp = array[k];
			array[k] = array[i];
			array[i] = temp;
		}
		return array;
	}
	//遍历输出数组
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}

