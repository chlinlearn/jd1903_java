/**
 * @author xuchunlin
 * @time 2019年6月7日上午9:57:11
 * @version
 * @description TODO
 */
package com.briup.tools;

import java.util.Arrays;

public class Sort {
	//数组实现插入排序
	public static void sortByInsert(int[] array) {
		int temp = 0;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			while(i>=1&&array[i-1]>temp) {
				array[i] = array[i-1];
				i--;
			} 
			array[i] = temp;
		}
	}
	
	//数组实现冒泡排序
	public static void sortByBubble(int[] array) {
		//最后一次交换的边界 
		int sortBorder = array.length-1;
		for (int i = 0; i < array.length-1; i++) {
			//没有交换
			boolean flag = false;
			for (int j = 0; j < sortBorder; j++) {
				if (array[j]>array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					sortBorder = j;
					//发生交换
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
	
	//数组实现选择排序
	public static void sortBySelect(int[] array) {
		//临时变量
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			//记录最大值得位置下标
			int index = 0;
			for (int j = 0; j < array.length-i; j++) {
				if (array[j]>array[index]) {
					index = j;
				}
			}
			temp = array[array.length-i-1];
			array[array.length-1-i] = array[index];
			array[index] = temp;
		}
	}
	
	//输出排序后的数组
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	/*	public static void main(String[] args) {
			int[] array = {12,34,8,4,25,68};
			//sortByBubble(array);
			//sortByInsert(array);
			sortBySelect(array);
			printArray(array);
		}*/

}

