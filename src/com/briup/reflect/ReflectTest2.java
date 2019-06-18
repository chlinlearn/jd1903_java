package com.briup.reflect;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/10:49
 * @description: 测试反射，通过镜像操作类中的属性，方法，构造器
 */
import java.lang.reflect.*;

public class ReflectTest2 {
    public static void main(String[] args) throws Exception{
        //1）获取Class对象
        Class clz = Class.forName("com.briup.reflect.Dog");
        //2)通过镜像对象创建对象(不使用new关键字),相当于Dog dog = new Dog()
        //调用类的无参构造器
        //Dog dog = (Dog)clz.newInstance();
        //System.out.println(dog);
        //调用有参构造器
        Constructor con = clz.getConstructor(String.class,int.class);
        Dog dog = (Dog)con.newInstance("大白",2);

        //3)操作属性，方法，构造器
        Field field = clz.getDeclaredField("name");
        //设置属性的访问权限
        field.setAccessible(true);
        //属性赋值,对象.属性名=属性值
        /*field.set(dog,"大黄");
        Object res = field.get(dog);
        System.out.println(res);*/

        System.out.println("-----method------");
        Method method = clz.getMethod("print",null);
        //调用方法
        method.invoke(dog);
        Method method1 = clz.getMethod("test",int.class,String.class);
        Object res1 = method1.invoke(clz,10,"hello");
        System.out.println(res1);
    }
}
