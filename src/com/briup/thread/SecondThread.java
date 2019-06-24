package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/15:05
 * @description: 实现Runnable类
 */

import com.briup.ch01.Second;

public class SecondThread implements Runnable {
    private int i=1;
    @Override
    public void run() {
        for (;i<=20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //实例化线程对象
        SecondThread r1 = new SecondThread();
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r1,"t2");
        t1.start();
        t2.start();
    }
}
