package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/16:17
 * @description: 设置标志变量来阻塞
 */

public class RaceTest extends Thread{
    private static boolean isEnd = false;//(static)共享变量

    public RaceTest(){}

    public RaceTest(String name){
        super(name);
    }
    @Override
    public void run() {
        int sum=0;
        while (sum<=100){
            if (isEnd){
                //stop();//过时方法
                return;
            }
            int index = (int)(Math.random()*10+1);
            sum += index;
            System.out.println(getName()+"跑了"+sum+"米");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEnd = true;
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println("start.........");
        Thread rabbit = new RaceTest("兔子");
        Thread tortoise = new RaceTest("乌龟");
        rabbit.start();
        tortoise.start();
        System.out.println(rabbit.isAlive());
        rabbit.join();//主线程会等待兔子线程结束
        tortoise.join();
        System.out.println("end...........");
        //System.out.println(rabbit.isAlive());
    }
}
