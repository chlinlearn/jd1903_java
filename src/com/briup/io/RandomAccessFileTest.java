package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/16:48
 * @description: 支持随机读写的流,处理大文件
 */

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(
                    "src/com/briup/io/RandomAccessFileTest.java","rw");
            //raf.write("//hi world".getBytes());
            raf.seek(300);//跳过300字节
            byte[] buff = new byte[1024];
            int len =-1;
            while ((len=raf.read(buff))!=-1){
                System.out.println(new String(buff,0,len));
            }
            //向该文件写数据,根据raf所在位置的指针决定输出的位置
            raf.write("//hello world".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}//hello world