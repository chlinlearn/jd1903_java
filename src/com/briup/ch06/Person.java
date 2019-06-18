/**
 * @author xuchunlin
 * @time 2019年6月6日上午9:30:57
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class Person {
	private String name;
	private String gender;
	private int age;
	
	public Person() {
		this("没有名字");
	}
	
	public Person(String name) {
		this.name = name;
	}
	public Person(String name,int age) {
		this(name);
		setAge(age);
	}
	public Person(String name,String gender,int age) {
		this(name,age);
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String stuGender3) {
		this.gender = stuGender3;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void talk() {
		System.out.println("...talk....");
	}
	
	public void display() {
		System.out.println("name:"+name+",age:"+age+",gender:"+gender);
	}
}

