/**
 * @author xuchunlin
 * @time 2019年6月13日上午9:41:17
 * @version
 * @description TODO
 */
package com.briup.collection;

//提供遍历集合中元素的标准
public interface Iterator {
	//判断是否有下一个数据
	public boolean hasNext();
	//取下一个数据
	public Object next();
	//删除迭代器中最后一个数据 
	public void remove();
}

