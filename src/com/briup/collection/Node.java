/**
 * @author xuchunlin
 * @time 2019年6月13日上午11:07:07
 * @version
 * @description TODO
 */
package com.briup.collection;

public class Node {
	private Object data;
	
	public Node next;
	
	public Node(Object data) {
		this.data = data;
	}
	
	public Node(Object data,Node next) {
		this(data);
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

