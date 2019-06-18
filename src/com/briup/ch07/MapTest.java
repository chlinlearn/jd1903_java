/**
 * @author xuchunlin
 * @time 2019年6月14日上午9:32:32
 * @version
 * @description TODO
 */
package com.briup.ch07;

import java.util.*;

//测试map：保存键值对
public class MapTest {
	
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put(1, new Student("tom",20,"male"));
		map.put(2, new Student("jack",20,"male"));
		map.put(3, new Student("lucy",20,"female"));
		map.put(4, new Student("lucy",20,"female"));//key存在时会更新数据
		map.remove(3);
		map.remove(5);
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.containsKey(5));
		
		//遍历map
		//out1(map);
		//out2(map);
		out3(map);

	}
	//根据keySet()
	public static void out1(Map map) {
		Set keys = map.keySet();
		Iterator iterator = keys.iterator();
		while(iterator.hasNext()) {
			Object key = iterator.next();
			Object value = map.get(key);
			System.out.println(key+"="+value);
		}
		
		for (Object key : keys) {
			Object value = map.get(key);
			System.out.println(key+"="+value);
		}
	}
	
	//根据entrySet()
	public static void out2(Map map) {
		Set entry = map.entrySet();
		Iterator iterator = entry.iterator();
		while(iterator.hasNext()) {
			Map.Entry m = (Map.Entry)iterator.next();
			Object key = m.getKey();
			Object value = m.getValue();
			System.out.println(key+":"+value);
		}
		for(Object temp:entry) {
			Map.Entry  m=(Map.Entry)temp;
			Object key = m.getKey();
			Object value = m.getValue();
			System.out.println(key+":"+value);
		}
	}
	
	//根据values
	public static void out3(Map map) {
		Collection coll = map.values();
		for (Object value : coll) {
			System.out.println(value);
		}
	}
}

