package com.briup.net;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/1/10:04
 * @description: TODO
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) throws Exception{
        //1)根据URL地址创建URL对象
            //URL地址，可以是网络上的资源，也可以是本地的文件
            //URL地址也可以指向数据库或者查询集
        URL url = new URL("https://www.easyicon.net/download/png/1066784/72/");
        //2)获取连接对象,获取输入流
        //InputStream in = url.openStream();
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        InputStream in = conn.getInputStream();
        //3)写到本地文件
        FileOutputStream fos = new FileOutputStream("src/com/briup/net/nba.png");
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len=in.read(buff))!=-1){
            fos.write(buff,0,len);
        }
        fos.flush();
        fos.close();
    }
}
