package com.briup.reflect;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/9:57
 * @description: 测试反射,通过反射获取class类中所有属性，方法和构造器
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //1)获取镜像对象（Class对象）
        Class clz = Class.forName("com.briup.reflect.Dog");
        //2)通过镜像对象获取所有的属性
        Field[] fields = clz.getDeclaredFields();
        for (Field filed:fields){
            //获取属性名
            String n = filed.getName();
            //获取类型
            Class c = filed.getType();
            //获取修饰符
            int m = filed.getModifiers();
            System.out.println(n+" "+c+" "+m);
        }
        //3)通过类镜像获取所有方法
        Method[] methods = clz.getDeclaredMethods();
        for (Method method:methods){
            //方法名
            String n = method.getName();
            //方法的返回值类型
            Class r = method.getReturnType();
            //方法修饰符
            int m = method.getModifiers();
            //方法的参数列表
            Class[] p = method.getParameterTypes();
            System.out.print(m+" "+r+" "+n+"("+p);
            for (Class temp:p){
                System.out.print(temp+",");
            }
            System.out.println(")");
        }
        //通过类镜像获取所有的构造器
        Constructor[] constructors = clz.getConstructors();
        for (Constructor constructor:constructors){
            //获取构造器的修饰符
            int m = constructor.getModifiers();
            //获取构造器的名字
            String n = constructor.getName();
            //获取构造器的参数列表
            Class[] p = constructor.getParameterTypes();
            //获取构造器的结构输出
            String s = constructor.toGenericString();
            System.out.print(m+" "+n+"("+p);
            for (Class temp:p){
                System.out.print(temp+",");
            }
            System.out.println(")"+s);
        }
    }
}
