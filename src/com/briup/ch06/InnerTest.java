/**
 * @author xuchunlin
 * @time 2019年6月12日上午10:38:21
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class InnerTest {
	public static void main(String[] args) {
		//创建实例内部类
		/*	InstanceInnerTest t = new InstanceInnerTest();
			InstanceInnerTest.InstanceInner in = t.new InstanceInner();
			
			InstanceInnerTest.InstanceInner in1 = new InstanceInnerTest().new InstanceInner();
			in.print();
			in1.print();*/
		
		//创建静态内部类
		/*StaticInnerTest.StaticInner ss = new StaticInnerTest.StaticInner();
		ss.print();	
		*/
		
		//创建局部内部类
		LocalInnerTest tt = new LocalInnerTest();
		tt.print();
	}
}

