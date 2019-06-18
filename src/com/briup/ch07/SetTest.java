/**
 * @author xuchunlin
 * @time 2019年6月13日下午12:20:23
 * @version
 * @description TODO
 */
package com.briup.ch07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set set = new HashSet<>();
		set.add(10);
		set.add("hello");
		set.add("word");
		set.add(10);
		System.out.println(set.size());
		out1(set);
		out2(set);
	}
	public static void out1(Set set) {
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next()+" ");
		}
	}
	public static void out2(Set set) {
		for (Object object : set) {
			System.out.println(object+" ");
		}
	}
}

