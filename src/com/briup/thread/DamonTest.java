package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/25/16:59
 * @description: 后台线程（精灵线程）
 */

public class DamonTest extends Thread{
    @Override
    public void run() {
        for (int i=1;i<20000;i++){
            System.out.println("后台线程："+i);
        }
    }

    public static void main(String[] args) {
        DamonTest thread = new DamonTest();
        thread.setDaemon(true);
        thread.start();
        //所有前台线程结束，后台线程会自动死亡
        for (int i=1;i<10;i++){
            System.out.println("主线程："+i);
        }
    }
}
