/**
 * @author xuchunlin
 * @time 2019年6月12日下午12:14:01
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class MaxMinTest {
	class MaxMin{
		private int max;
		private int min;
		public MaxMin() {
			
		}
		public MaxMin(int max,int min) {
			this.max = max;
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public int getMin() {
			return min;
		}
		
	}
	
	static class MaxMin2{
		private int max;
		private int min;
		public MaxMin2() {
			
		}
		public MaxMin2(int max,int min) {
			this.max = max;
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public int getMin() {
			return min;
		}
	}
	
	public static MaxMin2 getMaxMin(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length-1; i++) {
			if (max<array[i+1]) {
				max = array[i+1];
			}
			if (min>array[i+1]) {
				min = array[i+1];
			}
		}
		//return new MaxMinTest().new MaxMin(max,min);
		return new MaxMinTest.MaxMin2(max,min);
	}
	
	
	public static void main(String[] args) {
		//实例内部类实现最大值最小值得查找
		int[] array = {12,3,34,31,6,9,1};
		int max = getMaxMin(array).getMax();
		int min = getMaxMin(array).getMin();
		System.out.println(max);
		System.out.println(min);
		
		//静态内部类实现最大值最小值得查找
	}
}

