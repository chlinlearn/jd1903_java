package com.briup.ch03;

public class StarTest{
	public static void main(String[] args){
		//输出三角星星
		for(int i = 1;i<=7;i++){
			for(int j = 1;j<=i;j++){
				System.out.print('*');
			}
			System.out.print('\n');
		}
		System.out.print('\n');
		
		//func1
		for(int i=0;i<7;i++){
			for(int j=6;j>=0;j--){
				if(i>=j){
					System.out.print('*');
				}else{
					System.out.print(' ');
				}
			}
			System.out.print('\n');
		}
		
		//func2
		for(int i = 0;i<7;i++){
			for(int j = 7;j>i+1;j--){
				System.out.print(' ');
			}
			for(int k = 0;k<=i;k++){
				System.out.print('*');
			}
			System.out.print('\n');
		}
		
		//func3
		for(int i = 0;i<7;i++){
			for(int j = 7;j>i+1;j--){
				System.out.print(' ');
			}
			for(int k = 0;k<=i*2;k++){
				System.out.print('*');
			}
			System.out.print('\n');
		}
	}
}