package com.briup.io;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/27/14:35
 * @description: ObjectInputStream,ObjectOutputStream;
 */
//把一个对象写到文件或网络中称之为序列化，反之称为反序列化
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            //oos = new ObjectOutputStream(new FileOutputStream(
            //        "src/com/briup/io/emp"));
            ois = new ObjectInputStream(new FileInputStream(
                    "src/com/briup/io/emp"));
            Employee e1 = new Employee("jack",2000.0);
            Employee e2 = new Employee("tom",3000.0);
            //写数据，序列化
            /*oos.writeObject(e1);
            oos.writeObject(e2);
            oos.flush();*/
            //读对象，反序列化
            Employee t1 = (Employee)ois.readObject();
            Employee t2 = (Employee)ois.readObject();
            System.out.println(t1.getName()+" "+t1.getSalary()+" "+t1.getAge());
            System.out.println(t2.getName()+" "+t2.getSalary());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IoUtil.close(oos,ois);
        }
    }
}
