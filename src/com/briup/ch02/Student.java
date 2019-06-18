package com.briup.ch02;

public class Student{

	private long id;
	private String name;
	private int age;
	private String gender;
	
	
	public void study(){
		System.out.println(name+"������ѧϰ");
	}
	public void setId(long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}
}