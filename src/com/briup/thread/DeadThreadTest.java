package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/25/16:22
 * @description: 死锁测试
 *  解决方案，在加锁时尽量按照相同的顺序加锁
 */
class ATest extends Thread{
    private DeadThreadTest deadLock;

    public ATest(DeadThreadTest deadLock){
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.read();
    }
}

class BTest extends Thread{
    private DeadThreadTest deadLock;

    public BTest(DeadThreadTest deadLock){
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.write();
    }
}

public class DeadThreadTest {
    public static class Resource{
        private int value;
    }

    private final Resource resourceA = new Resource();
    private final Resource resourceB = new Resource();

    public void read(){
        //同时拿到两把锁才能执行
        synchronized (resourceA){
            try {
                Thread.sleep(1000);//sleep()不会释放对象锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceB){
                System.out.println("read......");
            }
        }
    }

    public void write(){
        synchronized (resourceB){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA){
                System.out.println("write......");
            }
        }
    }

    public static void main(String[] args) {
        DeadThreadTest d = new DeadThreadTest();
        Thread t1 = new ATest(d);
        Thread t2 = new BTest(d);
        t1.start();
        t2.start();
    }
}
