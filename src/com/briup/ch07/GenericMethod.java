package com.briup.ch07;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/14/12:01
 * @description: TODO
 */

import java.util.Collection;
import java.util.HashSet;

public class GenericMethod {
    private <E>void change(Collection<E> coll,E[] array){
        int i = 0;
        for(E temp:coll){
            array[i] = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        Collection<String> coll = new HashSet<>();
        coll.add("hello");
        coll.add("world");
        GenericMethod g = new GenericMethod();
        String[] array = new String[coll.size()];
        g.change(coll,array);
        System.out.println(array[0]+" "+array[1]);
    }
}
