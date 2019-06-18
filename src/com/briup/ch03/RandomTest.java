package com.briup.ch03;

public class RandomTest{
	public static void main(String[] args){
		//随机产生10个[200,500)之间的整数
		//Math.random()*(最大数-最小数+1)+最小数)
		for(int i = 0;i<10;i++){
			int result = (int)(Math.random()*(500-200+1)+200);
			System.out.print(result+" ");
		}
	}
}