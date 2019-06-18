/**
 * @author xuchunlin
 * @time 2019年6月6日下午12:00:13
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class Student extends Person{
	//扩展新的属性
	private int score;//学分
	
	public Student() {}
	
	public Student(String name,String gender,int age,int score) {
		super(name, gender, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score<0||score>100) {
			this.score = 0;
			return;
		}
		this.score = score;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("score:"+score);
	}
	
	//重写equals()方法
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj==null) {
			return false;
		}
		if (this.getClass()!=obj.getClass()) {
			return false;
		}
		if (obj instanceof Student) {
			Student s = (Student)obj;
			if (getName().equals(s.getName())
					&&getAge()==s.getAge()
					&&getGender().equals(s.getGender())
					&&getScore()==s.getScore()) {
				return true;
			}
		}
		return false;
	}
	
}

