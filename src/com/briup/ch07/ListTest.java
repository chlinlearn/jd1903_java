/**
 * @author xuchunlin
 * @time 2019年6月13日下午12:09:08
 * @version
 * @description TODO
 */
package com.briup.ch07;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List list = new LinkedList<>();
		list.add(10);
		list.add("hello");
		list.add(1, 100);
		list.add(2, "word");
		System.out.println(list.size());
		//遍历集合所有元素
		out1(list);
		out2(list);
		out3(list);
	}
	
	public static void out1(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void out2(List list) {
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next()+" ");		
		}
		System.out.println();
	}
	
	public static void out3(List list) {
		for (Object object : list) {
			System.out.println(object+" ");
		}
	}
}

