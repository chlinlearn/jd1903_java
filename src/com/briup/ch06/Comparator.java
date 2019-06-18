/**
 * @author xuchunlin
 * @time 2019年6月11日上午11:10:58
 * @version
 * @description TODO
 */
package com.briup.ch06;

//比较器，比较最大最小，比较内容不确定
public abstract class Comparator {
	//如果返回值大于0（s1>s2），
	//返回值等于0(s1=s2)，
	//返回值小于0(s1<s2)；
	public abstract int compare(Student s1,Student s2);

}

