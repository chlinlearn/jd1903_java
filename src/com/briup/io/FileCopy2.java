package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/26/15:33
 * @description: 字符流操作文件,FileReader,FileWriter
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy2 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("src/com/briup/gui/MyEdit.java");
            fw = new FileWriter("src/com/briup/io/b.txt");
            //读写数据
            /*int temp = -1;
            while ((temp=fr.read())!=-1){
                System.out.print((char)temp);
                fw.write(temp);
            }*/
            //速度更快的读取
            char[] c = new char[256];
            int len = -1;
            while ((len=fr.read(c))!=-1){
                System.out.print(new String(c,0,len));
                fw.write(c,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fr!=null){
                    fr.close();
                }
                if (fw!=null){
                    fw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
