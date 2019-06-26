package com.briup.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/26/15:00
 * @description: TODO
 */
//按照字节操作文件
//FileInputStream,FileOutputStream
public class FileCopy {
    public static void main(String[] args) {
        //把文件的数据读取到程序
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建流对象
            fis = new FileInputStream("src/com/briup/gui/MyEdit.java");
            fos = new FileOutputStream("src/com/briup/io/a.txt");
            //一个字节读数据
            /*int len = -1;
            while ((len=fis.read())!=-1){
                //转换成char类型
                System.out.print((char) len);
                //一个字节写数据
                fos.write(len);
            }*/

            //字节数组读写数据
            byte[] buff = new byte[256];//一次读取数组的长度个字节,但最后一次不能保证读到256个字节
            int len = -1;
            while ((len=fis.read(buff))!=-1){
                System.out.print(new String(buff,0,len));
                fos.write(buff,0,len);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null)
                    //关闭资源
                    fis.close();
                if (fos!=null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
