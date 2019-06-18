package com.briup.ch07;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/14/11:34
 * @description: TODO
 */

public class SimpleGeneric<E> {
    private E e;
    public SimpleGeneric(){

    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public void print(){
        System.out.println(e);
    }

    public static void main(String[] args) {
        SimpleGeneric<String> s = new SimpleGeneric<String>();
        s.setE("hello");
        s.print();
    }
}
