package com.briup.reflect;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/9:18
 * @description: TODO
 */
import java.io.*;
import java.util.*;

public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        //查看JVM的系统属性
        /*Properties p = System.getProperties();
        p.list(System.out);*/
        //获取系统参数
        /*String s1 = p.getProperty("name");
        System.out.println(s1);
        String s2 = p.getProperty("age");
        System.out.println(s2);*/
        //获取应用程序级别的参数
        System.out.println("1111 "+args[0]);
        System.out.println("2222 "+args[1]);
        //读取文件中的属性集
        Properties pro=new Properties();
        //加载文件
        String path="src/com/briup/reflect/info.properties";
        pro.load(new FileInputStream(path));
        System.out.println("name="+pro.getProperty("name"));
        System.out.println("password="+pro.getProperty("password"));
        System.out.println("url="+pro.getProperty("url"));
    }
}
