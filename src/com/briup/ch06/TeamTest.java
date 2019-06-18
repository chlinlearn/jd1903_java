/**
 * @author xuchunlin
 * @time 2019年6月10日下午12:03:11
 * @version
 * @description TODO
 */
package com.briup.ch06;

class AgeComparator extends Comparator {

	@Override
	public int compare(Student s1, Student s2) {
		System.out.println(s1.getAge()+" "+s2.getAge());
		int a = s1.getAge();
		int b = s2.getAge();
		int c = a-b;
		System.out.println(s2);
		return c;
	}

}

class NameComparator extends Comparator {
	@Override
	public int compare(Student s1, Student s2) {
		return s2.getName().compareTo(s1.getName());
	}
}

public class TeamTest {
	public static void main(String[] args) {
		Team team = new Team(4);
		Student s1 = new Student("jack", "男", 21, 99);
		Student s2 = new Student("jack", "男", 20, 99);
		team.addStudent(s1);
		team.addStudent(s2);
		Comparator a = new AgeComparator();
		Comparator n = new NameComparator();
		Student student = team.getMaxOrMin(a);
		student.display();
	}

}
