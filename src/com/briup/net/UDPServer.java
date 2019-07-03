package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/1/9:27
 * @description: 基于UDP协议的服务端
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        //1)创建DatagramSocket对象，并绑定端口号
        DatagramSocket ds = new DatagramSocket(8899);
        System.out.println("服务器端已经在8899端口启动");
        //2)接受数据包
        byte[] buff = new byte[2048];//用来存放数据
        DatagramPacket dp = new DatagramPacket(buff,buff.length);
        ds.receive(dp);//有阻塞的功能，等待数据包
        //3)输出数据包中的内容
        String str = new String(dp.getData());
        System.out.println("接受到客户端的数据包："+str);

        //4)发送数据包(内容，IP，端口号),客户端的ip和port
        String message = new Date().toString();
        buff = message.getBytes();
        int port = dp.getPort();
        InetAddress address = dp.getAddress();
        DatagramPacket dp1 = new DatagramPacket(buff,buff.length,address,port);
        ds.send(dp1);

        //5)关闭资源
        ds.close();
    }
}
