/**
 * @author xuchunlin
 * @time 2019年6月13日上午9:46:49
 * @version
 * @description TODO
 */
package com.briup.collection;

public class Test {
	public static void main(String[] args) {
		//List list = new ArrayList();
		List list = new LinkedList();
		list.add(10);
		list.add(true);
		list.add("你好");
		list.add(1, "world");
		list.add(2, "hello");
		//输出
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
		System.out.println(list.size());

		//迭代器
		System.out.println("-------------");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj+" ");
		}
		System.out.println(list.size());
	}
}
