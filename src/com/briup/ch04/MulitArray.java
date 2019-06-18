/**
 * @author xuchunlin
 * @time 2019年6月5日上午9:30:13
 * @version
 * @description TODO
 */
package com.briup.ch04;

//多维数组测试
public class MulitArray {
	public static void main(String[] args) {
		Student[][] rooms = new Student[3][];
		
		//每层楼构建房间
		rooms[0] = new Student[2];
		rooms[1] = new Student[3];
		rooms[2] = new Student[1];
		
		//每个房间分配学生
		rooms[0][0] = new Student("jack",20);
		rooms[0][1] = new Student("tom",22);
		rooms[1][0] = new Student("lili",21);
		rooms[1][1] = new Student("lisi",19);
		rooms[1][2] = new Student("lucy",20);
		rooms[2][0] = new Student("zhangsan",21);
		
		//输出每层楼的学生信息
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j].getName()+" ");
			}
			System.out.println();
		}
	}
}

