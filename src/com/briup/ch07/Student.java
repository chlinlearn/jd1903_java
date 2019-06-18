/**
 * @author xuchunlin
 * @time 2019年6月13日下午2:18:01
 * @version
 * @description TODO
 */
package com.briup.ch07;

public class Student implements Comparable{
	private String name;
	private int age;
	private String gender;
	//等级
	private Grand grand;

	public enum Grand{
	    A,B,C,D;
    }

	public Student() {
		
	}
	public Student(String name,int age,String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
    public Grand getGrand() {
        return grand;
    }
    public void setGrand(Grand grand) {
        this.grand = grand;
    }

    @Override
	public int hashCode() {
		//hashcode值本质是根据对象地址计算出来的
		//将对象里的内容的hashcode值相加，
		//如果最后值相同，则说明在同一个位置,来源同一地方。
		return name.hashCode()+age+gender.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		if (this==obj) {
			return true;
		}
		if (this.getClass()!=obj.getClass()) {
			return false;
		}
		if (obj instanceof Student) {
			Student s = (Student)obj;
			if (this.getName().equals(s.getName())
					&&this.getAge()==s.getAge()
					&&this.getGender().equals(s.getGender())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name+"-"+age+"-"+gender+"-"+grand;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student s = (Student)o;
			if (getAge()==s.getAge()) {
				return getName().compareTo(s.getName());
			}
			return getAge()-s.getAge();
		}
		return 0;
	}

    /*public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("tom");
        stu.setAge(20);
        stu.setGender("男");
        stu.setGrand(Grand.A);
        System.out.println(stu);
    }*/
}

