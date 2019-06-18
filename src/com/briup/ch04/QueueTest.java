/**
 * @author xuchunlin
 * @time 2019年6月5日上午11:33:42
 * @version
 * @description TODO
 */
package com.briup.ch04;

public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(10);
		queue.add(20);
		queue.add(30, 1);
		System.out.println("当前队列长度："+queue.size());
		queue.print();
		int res = queue.remove();
		System.out.println("当前队列长度："+queue.size());
		queue.print();
		System.out.println("当前队列长度："+queue.size());
		queue.print();
	}
}

