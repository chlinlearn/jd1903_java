/**
 * @author xuchunlin
 * @time 2019年6月10日上午10:40:20
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Rectangle extends Shape{
	private int x2;
	private int y2;
	
	public Rectangle() {}
	
	public Rectangle(int x2, int y2) {
		super();
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	@Override
	public void draw() {
		System.out.println("长为："+0+",宽为："+0);
	}
	

}

