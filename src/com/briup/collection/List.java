/**
 * @author xuchunlin
 * @time 2019年6月13日上午9:37:32
 * @version
 * @description TODO
 */
package com.briup.collection;

//提供对数据增删改查的规范
public interface List {
	public void add(Object obj);
	public void add(int index,Object obj);
	public Object remove(int index);
	public void set(int index,Object obj);
	public Object get(int index);
	public int size();
	public com.briup.collection.Iterator iterator();//获取该集合的迭代对象
}

