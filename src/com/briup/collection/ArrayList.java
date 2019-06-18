/**
 * @author xuchunlin
 * @time 2019年6月13日上午9:44:38
 * @version
 * @description TODO
 */
package com.briup.collection;

//使用数组实现集合list
public class ArrayList implements List{
	private int length = 0;
	private int size = 0;
	private Object[] array;
	
	public ArrayList() {
		this(5);
	}
	
	public ArrayList(int length) {
		array = new Object[length];
		this.length = length;
	}

	@Override
	public void add(Object obj) {
		add(size,obj);
	}

	@Override
	public void add(int index, Object obj) {	
		if (size>=length) {
			Object[] b = new Object[length+10];
			System.arraycopy(array, 0, b, 0, size);
			array = b;
			this.length += 10;
		}
		if (obj==null) {
			return;
		}
		if (index>=length||index<0) {
			return;
		}
		//0,3,1,2		
		for (int i = size; i >index; i--) {		
			array[i] = array[i-1];
		}
		array[index] = obj;
		size++;
	}

	@Override
	public Object remove(int index) {
		if (index<0||index>=size) {
			return null;
		}
		Object temp = array[index];
		for (int i = index; i < size-1; i++) {
			array[index] = array[index+1];
		}
		//把最后一个置空
		array[--size] = null;
		return temp;
	}

	@Override
	public void set(int index, Object obj) {
		if (index<0||index>=size) {
			return;
		}
		array[index] = obj;		
	}

	@Override
	public Object get(int index) {
		if (index<0||index>=size) {
			return null;
		}
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		
		//return new ArrayIterator();//成员内部类实现
		//匿名内部类实现
		return new Iterator() {
			private int position = -1;//迭代器的当前位置

			@Override
			public boolean hasNext() {
				if (position+1<size) {
					return true;
				}
				return false;
			}

			@Override
			public Object next() {
				return get(++position);
			}
			
			@Override
			public void remove() {
				ArrayList.this.remove(position--);
			}
			
		};
	}
	
	class ArrayIterator implements Iterator{
		private int position = -1;//迭代器的当前位置

		@Override
		public boolean hasNext() {
			if (position+1<size) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			return get(++position);
		}
		
		@Override
		public void remove() {
			ArrayList.this.remove(position--);
		}
		
	}

}

