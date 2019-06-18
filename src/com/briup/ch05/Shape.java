/**
 * @author xuchunlin
 * @time 2019年6月10日上午10:29:08
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class Shape {
	private int x;
	private int y;
	
	public Shape() {}
	
	public Shape(int x,int y) {
		setX(x);
		setY(y);
	}
	
	public void draw() {
		
	}
	
	public void draw(String title) {
		System.out.println("title:"+title);
		draw();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}

