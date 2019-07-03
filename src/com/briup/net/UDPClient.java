package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/1/9:26
 * @description: 基于UDP协议的客户端
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        //1)创建DatagramSocket对象，绑定IP地址和端口号
        DatagramSocket ds = new DatagramSocket();
        //2)发送数据包
        byte[] buff = new byte[2048];
        buff = "Give me your time".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(buff,buff.length,address,8899);
        ds.send(dp);
        //3)接受数据包
        DatagramPacket dp1 = new DatagramPacket(buff,buff.length);
        ds.receive(dp1);
        //4)输出数据包
        String str = new String(dp1.getData());
        System.out.println("接收到服务器端的数据："+str);

        //5)关闭资源
        ds.close();
    }
}
