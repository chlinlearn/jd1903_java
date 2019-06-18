/**
 * @author xuchunlin
 * @time 2019年6月13日下午2:20:24
 * @version
 * @description TODO
 */
package com.briup.ch07;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//set集合如何判断是否相等
//数据放在集合的哪个位置
public class StudentTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//自然排序
		//Set set = new TreeSet();
		//覆盖排序
		@SuppressWarnings("rawtypes")
		Set set = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Student s5 = (Student)o1;
				Student s6 = (Student)o2;
				if (s5.getAge()==s6.getAge()) {
					return s5.getName().compareTo(s6.getName());
				}
				return s5.getAge()-s6.getAge();
			}
			
		});
		
		Student s1 = new Student("tom",20,"male");
		Student s2 = new Student("jack",20,"male");
		Student s3 = new Student("lili",23,"male");
		Student s4 = new Student("lucy",22,"female");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		System.out.println(set.size());
		System.out.println(set);
	}
}

