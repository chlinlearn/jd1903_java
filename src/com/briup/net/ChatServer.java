package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/28/16:25
 * @description: TODO
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private ServerSocket ss;
    private Set<Socket> clients;

    public ChatServer(){
        try {
            ss = new ServerSocket(8888);
            clients = new HashSet<>();
            System.out.println("聊天室服务器启动....");
            while (true){
                Socket socket = ss.accept();
                clients.add(socket);
                //启动一个线程处理该客户端
                new ChatThread(socket,clients).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}

//接收客户端的数据并转发给所有的客户端
class ChatThread extends Thread{
    private Socket socket;
    private Set<Socket> clients;

    public ChatThread(Socket socket,Set<Socket> clients){
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            //读写数据
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String str = null;
            while ((str=br.readLine())!=null&&!socket.isClosed()){
                //把数据转发出去给所有客户端
                for (Socket client:clients){
                    PrintWriter pw = new PrintWriter(client.getOutputStream());
                    pw.println(str);
                    pw.flush();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
