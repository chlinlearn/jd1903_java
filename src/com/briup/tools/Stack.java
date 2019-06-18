/**
 * @author xuchunlin
 * @time 2019年6月5日下午6:32:51
 * @version
 * @description TODO
 */
package com.briup.tools;

//数组模拟栈
public class Stack {
	private int[] array;//模拟栈
	private int length = 0;//栈总长度
	private int size = 0;//栈存在元素个数
	
	public Stack() {
		this(10);
	}
	public Stack(int length) {
		array = new int[length];
		this.length = length;
	}
	
	//入栈
	public void push(int num) {
		isFull();
		array[size] = num;
		size++;
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			return 0;
		}
		int result = array[size-1];
		array[--size] = 0;
//		for (int i = 0; i < array.length; i++) {
//			if (array[i]==0) {
//				continue;
//			}
//			result = array[i];
//			array[i] = 0;
//			size--;
//			break;
//		}
		return result;
	}
	
	//栈是否为空
	public boolean isEmpty() {
		if(size==0) {
			System.out.println("栈为空！");
			return true;
		}
		return false;
	}
	
	//栈是否已满,已满则每次扩容5个单位
	public boolean isFull() {
		if (size==length) {
			//System.out.println("当前栈已满，扩容5个单位。");
			int[] b = new int[length+5]; 
			System.arraycopy(array, 0, b, 0, length);
			array = b;
			this.length += 5;
			return true;
		}
		return false;
	}
	
	//清除栈所有元素
	public void removeAll() {
		int temp = size;
		for (int i = 0; i < temp; i++) {
			if (array[i]!=0) {
				array[i] = 0;
				size--;
			}
		}
	}
	
	//获取栈内存在元素个数
	public int getSize() {
		return size;
	}
	
	//获取栈的总长度
	public int getLength() {
		return length;
	}
	
	//输出当前栈情况
	public void printStack() {
		System.out.print("当前栈情况:");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}

