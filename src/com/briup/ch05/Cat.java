/**
 * @author xuchunlin
 * @time 2019年6月6日上午10:11:43
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Cat {
	/*public String name;
	public String gender;
	public int age;*/
	private String name;
	private String gender;
	private int age;
	
	//无参构造器
	public Cat() {
		
	}
	
	public Cat(String name,int age) {
		setName(name);
		setAge(age);
	}
	
	public Cat(String name,Boolean gender,int age) {
		this(name,age);
		setGender(gender);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name==null) {
			this.name = "没有名字";
		}else {
			this.name = name;		
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		if (gender) {
			this.gender = "公";
		}else {
			this.gender = "母";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age<0||age>10) {
			this.age = 0;
			return;
		}
		this.age = age;
	}

	public void eat() {
		System.out.println("eat func...");
	}
}

