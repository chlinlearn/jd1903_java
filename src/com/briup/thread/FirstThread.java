package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/14:33
 * @description: 多线程,继承Thread类
 */

public class FirstThread extends Thread{
    static int i=1;
    //重写run方法
    @Override
    public void run() {
        for (;i<=20;i++){
            System.out.println(getName()+":"+i);
            try {
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * main Thread
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("start.........");
        //1.实例化线程对象
        Thread t1 = new FirstThread();
        t1.setName("t1");
        Thread t2 = new FirstThread();
        t2.setName("t2");
        //2.启动线程
        t1.start();
        t2.start();
        //3.等待CPU调度

        System.out.println("end...........");
    }
}
