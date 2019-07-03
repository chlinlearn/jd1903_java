package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/28/14:54
 * @description: 基于TCP协议的服务器端
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        //1)创建ServerSocket对象
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(9999);
            System.out.println("服务器端已经在9999端口启动...");
            while (true) {
                //2)等待客户端的连接,应该随时都在监听
                socket = ss.accept();//会有阻塞,直到客户端连接,连接成功会返回一个Socket对象
                //3)基于Socket对象来读写数据
                br = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                String msg = br.readLine();
                System.out.println("客户端：" + msg);
                pw = new PrintWriter(socket.getOutputStream());
                pw.println(new Date().toString());
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (socket != null) socket.close();
                if (ss != null) ss.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
