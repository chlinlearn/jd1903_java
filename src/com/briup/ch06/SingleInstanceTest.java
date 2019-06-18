/**
 * @author xuchunlin
 * @time 2019年6月11日上午9:55:07
 * @version
 * @description TODO
 */
package com.briup.ch06;

//单例模式
class Single {
	private static Single single;
	
	//恶汉式，先创建好	
	static {
		if (single==null) {
			single = new Single();
		}
	}
	
	private Single() {
		
	}
	
	public static Single getSingle() {			
		//懒汉式,要的时候创建
		/*	if (single==null) {
				single = new Single();
			}*/
		return single;
	}
	
	public void print() {
		System.out.println("print...");
	}
}

public class SingleInstanceTest {
	public static void main(String[] args) {
		/*Single s1 = new Single();
		Single s2 = new Single();*/
		System.out.println(Single.getSingle());
		System.out.println(Single.getSingle());
		Single.getSingle().print();
	}
}

