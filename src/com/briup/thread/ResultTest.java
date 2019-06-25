package com.briup.thread;

import java.util.concurrent.ExecutorService;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/25/15:05
 * @description: TODO
 */
//生成者线程
class Sender extends Thread{
    private Result result;

    public Sender(Result result,String name){
        super(name);
        this.result = result;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i=1;i<=100;i++){
            sum += i;
        }
        //将产品放到共有对象中
        result.setValue(sum);
    }
}

//消费者线程
class Printer extends Thread{
    private Result result;

    public Printer(Result result,String name){
        super(name);
        this.result = result;
    }

    @Override
    public void run() {
        int r = result.getValue();
        System.out.println(getName()+"获取到的产品为："+r);
    }
}

public class ResultTest {
    public static void main(String[] args) {
        Result result = new Result();
        Thread s = new Sender(result,"生产者");
        Thread p = new Printer(result,"消费者");
        p.start();//必须要先有wait()
        s.start();
    }
}
