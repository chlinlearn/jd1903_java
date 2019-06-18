package com.briup.ch07;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/14/11:44
 * @description: TODO
 */

import java.util.ArrayList;
import java.util.List;

interface VList<E>{
    public void add(E e);
    public E remove(int index);
    public int size();
}

public class MyList<E> implements VList<E>{
    private E[] array = (E[])new Object[10];

    private List<E> list = new ArrayList<E>();

    public MyList() {
        super();
    }

    @Override
    public void add(E e) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
