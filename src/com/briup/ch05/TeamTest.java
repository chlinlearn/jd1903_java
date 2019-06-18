/**
 * @author xuchunlin
 * @time 2019年6月10日下午12:03:11
 * @version
 * @description TODO
 */
package com.briup.ch05;

import java.util.Scanner;

public class TeamTest {
	//初始化一个团队
	static Address address = new Address("中国","昆山","学院路");
	static Team team = new Team(2,address);
	
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		print();
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			if (num==0) {
				System.out.println("系统正常退出！");
				break;
			}
			switch (num) {
			case 1:
				Scanner s = new Scanner(System.in);
				System.out.println("请输入你要添加的学生姓名：");
				String name = s.next();
				System.out.println("请输入你要添加的学生性别：");
				boolean gender = s.nextBoolean();			
				System.out.println("请输入你要添加的学生年龄：");
				int age = s.nextInt();
				//判断团队中是否已存在该学生
				boolean isExist = false;
				for (int i = 0; i < team.getSize(); i++) {
					if (team.getTeam()[i].getName()==name) {					
						isExist = true;
						break;
					}					
				}
				if (isExist) {
					System.out.println("你要添加的学生已存在");
				}else {
					team.addStudent(new Student(name, gender, age));
				}								
				break;
			case 2:
				System.out.println("请输入你要删除的学生编号：");
				Scanner stu2 = new Scanner(System.in);
				int stuNum2 = stu2.nextInt();
				stuNum2 -= 1;
				if (stuNum2>=team.getSize()) {
					System.out.println("该学生不在团队中，无法删除");
				}else {
					team.removeStudent(team.getTeam()[stuNum2]);
				}							
				break;
			case 3:			
				Scanner stu3 = new Scanner(System.in);
				System.out.println("请输入你要修改的学生编号：");
				int stuNum3 = stu3.nextInt();
				stuNum3 -= 1;
				if (stuNum3>=team.getSize()) {
					System.out.println("该学生不存在，无法修改");
				}else {
					System.out.println("请输入修改后的姓名：");
					//String stuName3 = stu3.nextLine();
					String stuName3 = stu3.next();
					System.out.println("请输入修改后的性别：");
					boolean stuGender3 = stu3.nextBoolean();
					System.out.println("请输入修改后的年龄：");
					int stuAge3 = stu3.nextInt();
					team.getTeam()[stuNum3].setName(stuName3);
					team.getTeam()[stuNum3].setGender(stuGender3);
					team.getTeam()[stuNum3].setAge(stuAge3);
					System.out.println("修改成功！");
				}	
				break;
			case 4:
				team.display();
				break;
			case 5:
				Scanner addr = new Scanner(System.in);
				System.out.println("请输入所在地国家：");
				String country = addr.nextLine();
				System.out.println("请输入所在地城市：");
				String city = addr.nextLine();
				System.out.println("请输入所在地街道：");
				String street = addr.nextLine();
				team.setAddress(new Address(country, city, street));
				System.out.println("修改团队所在地成功！");
				break;
			default:
				System.out.println("请输入正确的操作编号!");
				break;
			}
			print();
		}
		

	}
	
	public static void print() {
		System.out.println();
		System.out.println("-------------------学生团队信息管理系统--------------------");
		System.out.println("(1)添加学生 (2)删除学生 (3)修改学生信息 (4)显示学生信息 (5)修改团队所在地信息 (0)退出");
		System.out.println("当前团队有"+team.getSize()+"人，"+"团队所在地："+team.getAddress().getCountry()+team.getAddress().getCity()+team.getAddress().getStreet());
		System.out.println("请输入你要执行的操作序号：");			
	}
}

