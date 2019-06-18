/**
 * @author xuchunlin
 * @time 2019年6月12日下午7:26:52
 * @version
 * @description TODO
 */
package com.briup.ch06;

interface AgeComparator2{
	public int compare(Student s1,Student s2);
}

public class ComparatorInner {
	//将Age比较器定义成实例内部类
	public class AgeComparator{
		public int compare(Student s1,Student s2) {
			return s1.getAge()-s2.getAge();
		}
	}
	
	//将Age比较器定义成静态内部类
	/*	public static class AgeComparator{
			public int compare(Student s1,Student s2) {
				return s1.getAge()-s2.getAge();
			}
		}*/
	
	//将Age比较器定义成局部内部类
	public void compare(Student s1,Student s2) {
		class AgeComparator{
			public int compare(Student s1,Student s2) {
				return s1.getAge()-s2.getAge();
			}
		}
		AgeComparator a = new AgeComparator();
		a.compare(s1, s2);
	}
	
	// 将Age比较器定义成匿名内部类
	
	public static int print(AgeComparator2 a,Student s1,Student s2) {	
		return a.compare(s1,s2);
	}
	
	public static void main(String[] args) {
		int a =print(new AgeComparator2() {			
			@Override 
			public int compare(Student s1, Student s2) {
				return s1.getAge()-s2.getAge();
			}
		},new Student("jack", "男", 21, 99),new Student("jack", "男", 20, 99));
		System.out.println(a);
	}
}

