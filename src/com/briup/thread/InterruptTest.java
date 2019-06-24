package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/16:53
 * @description: TODO
 */

public class InterruptTest extends Thread {
    @Override
    public void run() {
        System.out.println("sleep....");
        long start = System.currentTimeMillis();
        try {
            sleep(10*1000);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupt....");
        }
        long end = System.currentTimeMillis();
        System.out.println("sleep over....");
        System.out.println(end-start);
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new InterruptTest();
        t.start();
        System.out.println(t.isInterrupted());
        sleep(3*1000);
        t.interrupt();//中断睡眠线程
        System.out.println(t.isInterrupted());
        Thread.interrupted();//清空中断
        System.out.println(t.isInterrupted());
    }
}
