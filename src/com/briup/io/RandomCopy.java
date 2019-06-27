package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/17:04
 * @description: 多点复制，模拟大文件的下载
 */

import sun.security.util.Length;

import java.beans.beancontext.BeanContext;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.concurrent.FutureTask;

//读操作
class ReadFrom{
    private RandomAccessFile raf = null;
    public ReadFrom(String srcPathName)throws Exception{
        raf = new RandomAccessFile(srcPathName,"r");
    }

    //pos需要跳过的字节数
    public int read(long pos,byte[] buff)throws Exception{
        raf.seek(pos);
        return raf.read(buff);
    }
}

class WriteTo{
    private RandomAccessFile raf = null;

    public WriteTo(String destPathName)throws Exception{
        raf = new RandomAccessFile(destPathName,"rw");
    }

    public void write(long pos,byte[] buff,int len)throws Exception{
        raf.seek(pos);
        raf.write(buff,0,len);
    }
}

public class RandomCopy extends Thread{
    private long begin;//开始位置
    private long end;//结束位置
    private WriteTo to;
    private ReadFrom from;
    public RandomCopy(long begin,long end,WriteTo to,ReadFrom from){
        this.begin = begin;
        this.end = end;
        this.to = to;
        this.from = from;
    }

    @Override
    public void run() {
        try {
            byte[] buff = new byte[1024];
            //读数据并写数据
            while (begin < end) {
                int len = from.read(begin, buff);
                //判断是否超出了结束的位置
                if (begin+len>end){
                    len = (int)(end-begin);
                }
                to.write(begin,buff,len);
                begin += len;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        String srcPath = "D:\\briup\\JD1903\\CoreJava\\corejava_day18\\jd1903_corejava_day18_1.wmv";
        String destPath = "D:\\briup\\JD1903\\CoreJava\\corejava_day18\\video.wmv";
        File file = new File(srcPath);
        long length = file.length();
        WriteTo to = new WriteTo(destPath);
        ReadFrom from = new ReadFrom(srcPath);
        Thread[] threads = new Thread[3];
        long start = System.currentTimeMillis();
        for (int i=0;i<3;i++){
            threads[i] = new RandomCopy(i*length/3,(i+1)*length/3,to,from);
            threads[i].start();
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成！耗时"+(end-start)/1000+"s");
    }
}
