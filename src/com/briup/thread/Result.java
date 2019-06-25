package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/25/15:04
 * @description: TODO
 */
//共有对象
public class Result {
    private int value;
    private boolean isWait = false;//是否有等待的线程

    public int getValue() {
        //等待
        synchronized (this){
            try {
                this.setWait(true);//设置标志变量,必须在wait()之前，否则阻塞之后setWait()不会被执行
                this.wait();//阻塞,会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        //判断是否有等待的线程
        while (!this.isWait()){
            try {
                Thread.sleep(1000);//睡一会，让出CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //通知在该对象上等待的线程
        synchronized(this){
            this.notify();
        }
    }

    public boolean isWait() {
        return isWait;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }
}
