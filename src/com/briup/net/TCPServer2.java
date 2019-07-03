package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/28/15:28
 * @description: 使用多线程
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServer2 {
    private ServerSocket ss;

    public TCPServer2(){
        try {
            ss = new ServerSocket(9999);
            System.out.println("服务器已启动...");
            while (true){
                Socket socket = ss.accept();
                //每来一个客户端就启动一个线程
                new ServerThread(socket).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServer2();
    }
}

class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //3)基于Socket对象来读写数据
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String msg = br.readLine();
            System.out.println("客户端：" + msg);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(new Date().toString());
            pw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}