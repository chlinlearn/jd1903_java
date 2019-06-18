/**
 * @author xuchunlin
 * @time 2019年6月10日上午11:40:15
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Team {
	//学生团队，存放学生对象
	private Student[] team;
	//团队总人数
	private int length = 0;
	//当前团队人数
	private int size = 0;
	//研发团队在什么地方
	private Address address;
	
	public Team() {
		this(5);
	}
	
	public Team(int length) {
		team = new Student[length];
		this.length = length;
	}
	public Team(int length,Address address) {
		this(length);
		this.address = address;
	}

	//向团队中添加学生
	public void addStudent(Student stu){
		if (stu==null) {
			System.out.println("不能添加空学生对象");
			return;
		}
		if (findStudent(stu)!=-1) {
			System.out.println("该学生已存在");
			return;
		}
		if (size>=length) {
			System.out.println("该团队已满");
			return;
		}		
		team[size] = stu;
		size++;
		System.out.println("添加成功！");
	}
	//从团队中删除学生
	public void removeStudent(Student stu){
		if (stu==null) {
			System.out.println("该学生不能为空");
			return;
		}
		if (findStudent(stu)==-1) {
			System.out.println("该学生不在团队中，无法删除");
			return;
		}
		int index = findStudent(stu);
		for (int i = index; i < size-1; i++) {
			team[i] = team[i+1];
		}
		team[--size] = null;
		System.out.println("删除成功！");
	}
	//从团队中找学生的索引
	public int findStudent(Student stu){
		int index = -1;
	for (int i = 0; i < team.length; i++) {
		if (team[i]==stu) {
			index = i;
			break;
		}
	}
		return index;
	}
	//显示团队中学生的信息
	public void display(){
		System.out.println("团队学生信息为：");
		if (size==0) {
			System.out.print("空");
		}
		for (int i = 0; i < size; i++) {
			Student s = team[i];
			int n = i+1;
			System.out.println("编号："+n+",姓名："+s.getName()+",性别："+s.getGender()+",年龄："+s.getAge());	
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student[] getTeam() {
		return team;
	}

	public void setTeam(Student[] team) {
		this.team = team;
	}
	
	

}

