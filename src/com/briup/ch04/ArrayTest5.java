/**
 * @author xuchunlin
 * @time 2019年6月5日上午9:44:21
 * @version
 * @description TODO
 */
package com.briup.ch04;

public class ArrayTest5 {
	public static void main(String[] args) {
		//数组的拷贝
		int[] a = {1,2,3,4,5};
		int[] b = new int[10];
		/**
		 * 参数含义
		 * @param src 原数组对象的引用
		 * @param srcPos 原数组要拷贝的数据的原始位置
		 * @param dest 目标数组对象的引用
		 * @param destPos 目标数组要拷贝的数据的原始位置
		 * @param length 原数组要拷贝的长度
		 */
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println(a.length);
		System.out.println(b.length);
		a = b;
		System.out.println(a.length);
		
		printMatrix();
		printYangHui();
	}
	//生成并输出方阵矩形
	public static void printMatrix() {
		int[][] array = new int[6][6];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i==j) {
					array[i][j] = 0;
				}else if (i>j) {
					array[i][j] = 1;
				}else {
					array[i][j] = 2;
				}
			}
		}
		print(array);
	}
	//输出矩形方法
	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//输出杨辉三角
	public static void printYangHui() {
		int n = 10;
		int[][] array = new int[n][];
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[i+1];
			for (int j = 0; j < array[i].length; j++) {
				if (i==0||j==0||i==j) {
					array[i][j] = 1; 
				}else {
					array[i][j] = array[i-1][j]+array[i-1][j-1];
				}
			}
		}
		print(array);
	}
}

