/**
 * @author xuchunlin
 * @time 2019年6月10日上午10:40:44
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class ShapeTest {
	public static void draw(Shape shape) {
		shape.draw();
	}
	
	public static void draw(Shape shape,String title) {
		shape.draw(title);
	}
	
	public static void main(String[] args) {
		Shape s = new Circle(10,20,5);
		draw(s);
		draw(s, "这是一个圆");
		System.out.println("----------------");
		s.draw();
		s.draw("这是一个圆");
		System.out.println("----------------");
		Circle circle = new Circle(1,2,3);
		circle.draw();
		circle.draw("这是一个圆");
	}

}

