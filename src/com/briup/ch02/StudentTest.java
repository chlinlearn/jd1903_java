package com.briup.ch02;

public class StudentTest{
	public static void main(String[] args){
		Student s = new Student();
		s.setName("jack");
		System.out.println(s.getName());
		s.study();
		Student s1 = new Student();
		s1.setId(2016211001);
		s1.setName("xcl");
		s1.setAge(20);
		s1.setGender("男");
		System.out.println(s1.getId()+" "+s1.getName()+" "+s1.getAge()+" "+s1.getGender());
	}
}