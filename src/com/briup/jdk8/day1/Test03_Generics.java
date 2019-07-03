package com.briup.jdk8.day1;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/9:36
 * @description: null
 */

import com.briup.enums.Month;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

@FunctionalInterface
interface Work<V,T>{
    public T doWork(V v);
}

interface Action<T>{
    public void run(T t);
}

interface Action2{
    public Model run(String name);
}

class Model{
    private String name;

    public Model(){
        System.out.println("jack");
    };

    public Model(String name){
        this.name = name;
        System.out.println(name);
    }

    public void test1() {
        System.out.println("test1");
    }
    public void test2(String s) {
        System.out.println("test2");
    }
    public int test3() {
        System.out.print("test3....");
        return 1;
    }
}


public class Test03_Generics {
    public static void main(String[] args) {
        /*Work<Integer,String> w = new Work<Integer, String>() {
            @Override
            public String doWork(Integer integer) {
                return integer+"hello";
            }
        };
        String s = w.doWork(1234);
        System.out.println(s);*/

//        Work<String,Integer> w = Integer::parseInt;
//        System.out.println(w.doWork("1234"));
//
//        Model m = new Model();
        /*Action<Model> a = new Action<Model>() {
            @Override
            public void run(Model model) {
                model.test1();
                model.test2("hello");
                int n = model.test3();
                System.out.println(n);
            }
        };
        a.run(m);*/

        /*Action<Model> a = Model::test3;
        a.run(m);*/

        Action2 a = Model::new;
       // Action2 aa = name->new Model(name);
        a.run("tom");
        //a.run();
    }
}
