/**
 * @author xuchunlin
 * @time 2019年6月6日下午12:03:46
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("tom");
		System.out.println(person.getName());
		
		Student student = new Student();
		student.setName("jack");
		student.setScore(100);
		System.out.println(student.getName());
		
		person.display();
		student.display();
				
	}
}

