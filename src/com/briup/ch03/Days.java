package com.briup.ch03;

public class Days{
	public static void main(String[] args){
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int days = 0;
		boolean flag = true;
		switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				days = 31;
				break;
			case 4:case 6:case 9:case 11:
				days = 30;
				break;
			case 2:
				if(year%400==0||(year%100!=0&&year%4==0)){
					days = 29;
				}else{
					days = 28;
				}
				break;
			default:
				flag = false;
				System.out.println("月份不合法");
		}
		if(flag){
			System.out.println(year+"年"+month+"月"+days+"天");
		}		
	}
}

