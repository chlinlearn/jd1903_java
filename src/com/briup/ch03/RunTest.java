package com.briup.ch03;

public class RunTest{
	//ʹ��main������������ն���������
	public static void main(String[] args){
		//ȡ�������еĵ�һ��Ԫ�ز�ת��ΪInteger
		Integer year = Integer.parseInt(args[0]);
		if(year%400==0 || (year%100!=0&year%4==0)){
			System.out.print(year+"������");
		}else{
			System.out.print(year+"��������");
		}
	}
}