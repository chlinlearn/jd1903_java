/**
 * @author xuchunlin
 * @time 2019年6月4日下午2:52:56
 * @version
 * @description TODO
 */
package com.briup.ch04;

import java.util.Arrays;

import com.briup.ch04.Student;

public class ArrayTest2 {
	public static void main(String[] args) {
		//动态初始化
		/*
		 * //1)声明引用数据类型数组 Student[] stus; //2)创建数组 stus = new Student[5]; //3)赋值 stus[0]
		 * = new Student("tom",20); stus[1] = new Student("jack",20);
		 */
		//静态初始化
		Student[] stus = new Student[] {
				new Student("jack",20),
				new Student("tom",20),
				new Student("lili",20)
		};
		//4)遍历数组
		for(int i = 0;i<stus.length;i++) {
			Student stu = stus[i];
			if(stu!=null)
				System.out.println(stu.getName());
		}
	}
}

