package com.briup.ch02;

import java.util.*;



/**
*@author xuchunlin
*@version jdk1.8
*/
public class CommentTest{
	private String name;
	private int age;
	
	/*
	*print
	*/
	public void print(){
	
		System.out.println("name:"+name+",age:"+age);
		System.out.println("�˳�");
	}//end print
	
	/**
	*@param args 
	*/
	public static void main(String[] args){
		CommentTest c = new CommentTest();
		c.print();
	}//end main
}//end class