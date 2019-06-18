/**
 * @author xuchunlin
 * @time 2019年6月4日下午2:54:01
 * @version
 * @description TODO
 */
package com.briup.ch04;

public class Student {
	private String name;
	
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name,int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

