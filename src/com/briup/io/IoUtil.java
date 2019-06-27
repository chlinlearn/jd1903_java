package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/14:14
 * @description: io工具类
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtil {
    //关闭资源的操作
    public static void close(Writer out){
        close(out,null);
    }
    public static void close(Reader in){
        close(null,in);
    }
    public static void close(OutputStream out){
        close(out,null);
    }
    public static void close(InputStream in){
        close(null,in);
    }

    public static void close(Writer out, Reader in){
        try {
            if (out != null) out.close();
            if (in != null) in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close(OutputStream out, InputStream in){
        try {
            if (out != null) out.close();
            if (in != null) in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
