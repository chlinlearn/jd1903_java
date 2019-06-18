/**
 * @author xuchunlin
 * @time 2019年6月5日下午6:33:02
 * @version
 * @description TODO
 */
package com.briup.tools;

public class StackTest {
	public static void main(String[] args) {
		//创建一个默认长度为10的栈
		Stack stack = new Stack(2);
		//入栈
		stack.push(10);
		stack.push(9);
		stack.push(8);
		System.out.println("当前栈元素个数:"+stack.getSize());
		System.out.println("当前栈的总长度:"+stack.getLength());
		stack.printStack();
		
		//出栈
		int p = stack.pop();
		System.out.println("当前出栈元素的值:"+p);
		System.out.println("当前栈元素个数:"+stack.getSize());
		System.out.println("当前栈的总长度:"+stack.getLength());		
		stack.printStack();
		
		//清空栈
		stack.removeAll();
		//stack.isEmpty();
		int p2 = stack.pop();
		System.out.println("当前出栈元素的值:"+p2);
		System.out.println("当前栈元素个数:"+stack.getSize());
		System.out.println("当前栈的总长度:"+stack.getLength());	
	}
}

