/**
 * @author xuchunlin
 * @time 2019年6月6日下午12:00:13
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Student extends Person{
	//扩展新的属性
	private int score;//学分
	
	public Student() {}
	
	public Student(String name,boolean gender,int age) {
		super(name, gender, age);
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
	
	
}

