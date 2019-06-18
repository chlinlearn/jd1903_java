/**
 * @author xuchunlin
 * @time 2019年6月6日上午10:14:08
 * @version
 * @description TODO
 */
package com.briup.ch05;

public class CatTest {
	public static void main(String[] args) {
		Cat cat = new Cat();
		//不安全，可能是非法、无效数据
		/*cat.name = "dabai";
		cat.gender = "公";
		cat.age = 2;
		System.out.println(cat.name);*/
		cat.setName("dabai");
		cat.setAge(-1);
		cat.setGender(true);
		System.out.println("cat'name:"+cat.getName());
		System.out.println("cat'age:"+cat.getAge());
		System.out.println("cat'gender:"+cat.getGender());
	}
}

