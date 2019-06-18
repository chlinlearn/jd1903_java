package com.briup.ch07;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/14/11:39
 * @description: TODO
 */

public class TwoGeneric<K,V> {
    private K k;
    private V v;
    public TwoGeneric(K k,V v){
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void setV(V v) {
        this.v = v;
    }

}
