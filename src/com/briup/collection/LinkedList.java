/**
 * @author xuchunlin
 * @time 2019年6月13日上午9:45:44
 * @version
 * @description TODO
 */
package com.briup.collection;

//使用链表实现集合
public class LinkedList implements List{
	private Node head;//头结点
	private int size;//长度
	
	public LinkedList() {
		head = new Node(null);
		head.next = null;
	}

	@Override
	public void add(Object obj) {	
		add(size, obj);
	}

	@Override
	public void add(int index, Object obj) {
		if (index<0||index>size) {
			return;
		}
		Node currNode = head;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		Node node = new Node(obj);
		node.next = currNode.next;
		currNode.next = node;
		size++;
	}

	@Override
	public Object remove(int index) {
		if (index<0||index>=size) {
			return null;
		}
		Node currNode = head;
		Node preNode = null;
		for (int i = 0; i <= index; i++) {
			preNode = currNode;
			currNode = currNode.next;
		}
		Object temp = currNode;
		preNode.next = currNode.next;
		currNode = null;
		size--;
		return temp;
	}

	@Override
	public void set(int index, Object obj) {
		if (index<0||index>=size) {
			return;
		}
		Node currNode = head;
		for (int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		currNode.setData(obj);
	}

	@Override
	public Object get(int index) {
		if (index<0||index>=size) {
			return null;
		}
		Node currNode = head;
		for (int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		return currNode.getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {		
		return new Iterator() {
			private int position = -1;
			
			@Override
			public void remove() {
				LinkedList.this.remove(position--);
			}
			
			@Override
			public Object next() {
				return get(++position);
			}
			
			@Override
			public boolean hasNext() {
				if(position+1<size) {
					return true;
				}				
				return false;
			}
		};
	}

}

