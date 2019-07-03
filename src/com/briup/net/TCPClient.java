package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/28/15:10
 * @description: 基于TCP协议的客户端
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            //1)创建Socket对象并绑定IP地址和端口号
            socket = new Socket("127.0.0.1",9999);
            //2)基于Socket读写数据
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("发送当前时间给我！");
            pw.flush();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = br.readLine();
            System.out.println("服务器："+msg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //3)关闭资源
            try {
                if (br!=null) br.close();
                if (pw!=null) pw.close();
                if (socket!=null) socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
