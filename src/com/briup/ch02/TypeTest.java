package com.briup.ch02;

import java.math.*;


public class TypeTest{
	/**
	*@param args main
	*/
	public static void main(String [] args){

		boolean b1 = true;

		char c1 = 'c';
		char c2 = 'a';
		char c3 = 97;
		char c4 = 0x0061;
		char c5 = '\u0061';
		System.out.println(c1+" "+c2+" "+c3+" "+c4+" "+c5+" ");
		
		
		String s1 = "hello";
		System.out.println(s1+1+2);
		System.out.println(1+2+s1);
		System.out.println(s1);
		System.out.println(s1+(1+2));
		System.out.println((1+2)+s1);
		

		byte ia = 127;
		byte ib = (byte)128;

		byte ic = (byte)-129;
		
		float f1 = 12.9f;
		double f2 = 12.8;
		System.out.println(f1+f2);
		
		double d1 = 12.0;
		double d2 = 11.1;
		System.out.println(d1-d2); 
		

		BigDecimal big1 = new BigDecimal("2.0");
		BigDecimal big2 = new BigDecimal("1.1");
		BigDecimal big3 = big1.subtract(big2);
		System.out.println(big3);
		
		System.out.println((1000*1000*1000*1000*60)/(1000*1000*1000*1000));
	}
}