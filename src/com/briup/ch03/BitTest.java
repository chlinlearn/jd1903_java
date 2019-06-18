package com.briup.ch03;

public class BitTest{
	//���������
	public static void print(int num){
		System.out.print(num+"�Ķ�����λ:\t");
		int count = 0;
		for(int i=31;i>=0;i--){
			count++;
			System.out.print(num>>i&1);
			if(count%4==0){
				System.out.print(" ");
			}
		}
		System.out.print("\n");
	}
	//����λ��1,����ʮ����
	public static int bitSet(int num,int index){
		return num | (1<<(index-1));
	}
	//����λ����
	public static int bitZero(int num,int index){
		return num & ~(1<<(index-1));
	}
	//����λȡ��
	public static int bitReverse(int num,int index){
		return num ^ (1<<(index-1));
	}
	
	public static void main(String[] args){
		print(10);
		print(-10);
		int r1 = bitSet(10,3);
		print(r1);
		int r2 = bitZero(10,2);
		print(r2);
		int r3 = bitReverse(10,1);
		print(r3);
	}
}