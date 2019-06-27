package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/15:15
 * @description: 管道输入输出流,PipedInputStream,PipedOutputStream;
 *   针对于线程间的通信
 */

import java.io.*;

//向管道输出流写数据
class Sender extends Thread{
    private PipedOutputStream pos = null;

    public Sender(PipedOutputStream pos){
        this.pos = pos;
    }

    @Override
    public void run() {
        DataOutputStream oos = null;
        try {
            oos = new DataOutputStream(pos);
            for (int i=1;i<=20;i++){
                oos.writeInt(i);
                oos.flush();
                sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//从管道输入流读数据
class Printer extends Thread{
    private PipedInputStream pis = null;

    public Printer(PipedInputStream pis){
        this.pis = pis;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(pis);
            for (int i=1;i<=20;i++){
                int result=dis.readInt();
                System.out.println("读到的数据："+result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class PipedTest {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            pos.connect(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sender s = new Sender(pos);
        Printer p = new Printer(pis);
        p.start();
        s.start();
    }
}
