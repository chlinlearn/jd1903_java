/**
 * @author xuchunlin
 * @time 2019年6月10日上午10:34:12
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Circle extends Shape{
	private int r;
	
	public Circle() {}
	
	public Circle(int x,int y,int r) {
		super(x,y);
		setR(r);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		if (r<=0) {
			this.r = 0;
			return;
		}
		this.r = r;
	}
	
	@Override
	public void draw() {
		System.out.println("圆心为：("+getX()+","+getY()+"),半径为："+getR());
	}
	
	
}

