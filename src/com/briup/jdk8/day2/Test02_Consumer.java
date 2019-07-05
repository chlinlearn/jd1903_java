package com.briup.jdk8.day2;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/4/14:31
 * @description: 消费者
 */

import java.util.function.Consumer;

public class Test02_Consumer {
    public static void main(String[] args) {
        Model m = new Model();
        Consumer<Model> c = new Consumer<Model>() {
            @Override
            public void accept(Model model) {
                System.out.println(model.getName());
            }
        };
        c.accept(m);

        System.out.println("--------------");
        Consumer<Model> c2 = model->model.setName("tom");
        c2.accept(m);
        System.out.println(m.getName());

        System.out.println("--------------");
        Consumer<Model> c3 = c2.andThen(c);
        c3.accept(m);
    }
}
