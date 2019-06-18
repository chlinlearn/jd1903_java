/**
 * @author xuchunlin
 * @time 2019年6月6日下午12:02:20
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Teacher extends Person{
	private String title;//职称
	
	public Teacher() {
		
	}
	
	public Teacher(String name,boolean gender,int age,String title) {
		super(name, gender, age);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title==null) {
			this.title = "没有职称";
			return;
		}
		this.title = title;
	}
	
	
}

