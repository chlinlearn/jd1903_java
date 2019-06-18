/**
 * @author xuchunlin
 * @time 2019年6月14日上午10:18:01
 * @version
 * @description TODO
 */
package com.briup.ch07;

import java.util.*;


public class GenericsTest {
	public static void jdk5Before() {
		List list = new ArrayList();
		list.add(2);
		list.add(23);
		
		Iterator iterator = list.iterator();
		int sum = 0;
		while(iterator.hasNext()) {
			Object temp = iterator.next();
			if (temp instanceof Integer) {
				 sum += (Integer)temp;				
			}
		}
		System.out.println("sum="+sum);
	}
	
	//有了泛型,可以在编译期的时候检查数据类型
	public static void jdk5After() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(45);
		list.add(25);
		list.add(66);
		//list.add("hello");
		Iterator<Integer> iter = list.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			Integer i = iter.next();
			sum += i;
		}
		System.out.println("sum="+sum);
	}

	//泛型方式Set
	public static void setTest(){
        Set<Student> set=new HashSet<Student>();

    }


	public static void main(String[] args) {
		//jdk5Before();
		jdk5After();
	}
}

