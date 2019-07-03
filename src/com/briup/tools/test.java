package com.briup.tools;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/18:03
 * @description: null
 */
abstract class T{
    final void test1(){};
    static void test2(){};
    abstract void test3();
    private void test4(){};
}

public class test extends T{
    @Override
    void test3() {

    }

    public static void main(String[] args) {
        String[] strings;
       // System.out.println(strings.toString());
        System.out.println(963362/16);
        System.out.println(963362>>4);

    }
}

class MyThread extends Thread implements Runnable {
    public void run() {
        setName("Hello");
        System.out.print(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        try {
            Thread myThread = new MyThread();
            Thread myThread2 = new Thread(new MyThread());
            myThread.start();
            myThread.join();
            myThread2.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
