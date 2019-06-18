/**
 * @author xuchunlin
 * @time 2019年6月5日上午11:08:17
 * @version
 * @description TODO
 */
package com.briup.ch04;

//使用数字模拟队列（银行取号）
public class Queue {
	private int[] array;//队列
	private int length;//总长度
	private int size = 0;//当前排队长度
	
	//默认构造器--创建队列
	public Queue() {
		this(10);
	}
	//有参构造器
	public Queue(int length) {
		array = new int[length];
		this.length = length;
	}
	
	//检查数组是否已满,如果已满就扩充容量
	private void check() {
		if (size>=length) {
			int[] n = new int[length+5];
			System.arraycopy(array, 0, n, 0, length);
			array = n;
			this.length += 5;
		}
	}
	
	//插队
	public void add(int value,int index) {
		check();
		if(index<0||index>size) {
			System.out.println("插入位置不合法");
			return;
		}
		/*
		 * for (int i = size; i > index; i--) { array[i] = array[i-1]; array[index] =
		 * value; size++; }
		 */
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = value;
		size++;
	}
	
	//入队
	public void add(int value) {
		check();
		array[size] = value;
		size++;
	}
	//出队
	public int remove() {
		if (size<=0) {
			System.out.println("当前队列没有数据！");
			return -1;
		}
		int result = array[0];
		//后面的数据往前移动一个
		/*
		 * for (int i = 0; i < size-1; i++) { array[i] = array[i+1]; }
		 */
		System.arraycopy(array, 1, array, 0, size-1);
		array[--size] = 0;
		return result;
	}
	
	//获取当前队列长度
	public int size() {
		return size;
	}
	
	//输出队列情况
	public void print() {
		System.out.print("当前队列为：");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}

