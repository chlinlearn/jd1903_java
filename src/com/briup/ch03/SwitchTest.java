package com.briup.ch03;

public class SwitchTest{
	public static void main(String[] args){
		//switch ����ı�����������ֻ���ǣ�byte,char,short,int,
		//1.8�汾֧�� String,1.5�汾֧�� ö��
		char a = 'c';
		switch(a){
			case 'a':
				System.out.print("A");
				break;
			case 'c':
				System.out.print("C");
				break;
			default:
				System.out.print("Other");
				break;
		}
	}
}