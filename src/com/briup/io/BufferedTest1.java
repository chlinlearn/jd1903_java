package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/26/16:31
 * @description: 测试BufferedInputStream,BufferedOutputStream
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//处理字节流
public class BufferedTest1 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        //FileInputStream fis = null;
        //FileOutputStream fos = null;
        try {
            //fis = new FileInputStream("src/com/briup/io/a.txt");
            bis = new BufferedInputStream(new FileInputStream("src/com/briup/io/a.txt"));
            //fos = new FileOutputStream("src/com/briup/io/c.txt");
            bos = new BufferedOutputStream(new FileOutputStream("src/com/briup/io/c.txt"));
            byte[] buff = new byte[256];
            int len = -1;
            while ((len=bis.read(buff))!=-1){
                System.out.print(new String(buff,0,len));
                bos.write(buff,0,len);
            }
            bos.flush();//手动刷新
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //if (fis!=null)fis.close();
                if (bos!=null)bos.close();//关闭时会自动将缓冲区刷新到文件,缓冲区满了时也会自动刷新
                if (bis!=null)bis.close();
                //if (fos!=null)fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
