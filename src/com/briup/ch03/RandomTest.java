package com.briup.ch03;

public class RandomTest{
	public static void main(String[] args){
		//�������10��[200,500)֮�������
		//Math.random()*(�����-��С��+1)+��С��)
		for(int i = 0;i<10;i++){
			int result = (int)(Math.random()*(500-200+1)+200);
			System.out.print(result+" ");
		}
	}
}