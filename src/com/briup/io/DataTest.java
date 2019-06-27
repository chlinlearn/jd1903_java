package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/14:10
 * @description: 基本数据类型的读写,DataInputStream,DataOutputStream
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataTest {
    public static void main(String[] args) {
        //声明
        DataOutputStream dos = null;
        DataInputStream dis = null;
        //创建
        try {
            dos = new DataOutputStream(new FileOutputStream(
                    "src/com/briup/io/data.txt"));
            dis = new DataInputStream(new FileInputStream("src/com/briup/io/data.txt"));
            dos.writeChar('a');
            dos.writeFloat(1.2f);
            dos.writeInt(10);
            dos.writeUTF("hello");
            dos.flush();
            //读数据
            System.out.println(dis.readChar());
            System.out.println(dis.readFloat());
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IoUtil.close(dos,dis);
        }

    }
}
