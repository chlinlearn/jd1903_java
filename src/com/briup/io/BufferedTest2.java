package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/26/16:53
 * @description: 测试BufferedReader,BufferWriter
 */

import java.io.*;

public class BufferedTest2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        //BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            //把字节流转化为字符流,很重要的一种操作
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/com/briup/io/a.txt"),"UTF-8"));
            //br = new BufferedReader(new FileReader("src/com/briup/io/a.txt"));
            //bw = new BufferedWriter(new FileWriter("src/com/briup/io/d.txt"));
            //bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/com/briup/io/d.txt")));
            pw = new PrintWriter("src/com/briup/io/d.txt");
            String msg = null;
            while ((msg=br.readLine())!=null){
                System.out.println(msg);
                //bw.write(msg);
                //bw.write(msg+"\n");//换行,不同的操作系统可能不一致，所以不建议使用
                //bw.newLine();//添加换行符,建议使用
                pw.println(msg);
            }
            //bw.flush();
            pw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (br!=null)br.close();
                //if (bw!=null)bw.close();
                if (pw!=null)pw.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
