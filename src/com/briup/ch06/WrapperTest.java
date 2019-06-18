/**
 * @author xuchunlin
 * @time 2019年6月12日上午9:25:35
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class WrapperTest {
	public static void main(String[] args) {
		Object[] obj = new Object[10];
		//装箱:基本数据类型转换成包装类
		obj[0] = 10;
		obj[1] = Integer.valueOf(12);
		obj[2] = new Integer(14);
		
		//包装类不能进行四则运算,需要进行转换，jdk1.5之前手动拆箱
		int result = ((Integer)obj[0]).intValue()+((Integer)obj[1]).intValue();
		
		//jdk1.5之后可以自动拆箱
		int res = (Integer)obj[0]+(Integer)obj[1];
		
		Integer i1 = 127;
		Integer i2 = 127;//常量池有1个字节（8位）
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i1==i2);//true
		System.out.println(i3==i4);//false
		
		Student s1 = new Student("tom","男",23,98);
		Student s2 = new Student("tom","男",23,99);
		System.out.println(s1.equals(s2));
	}
}

