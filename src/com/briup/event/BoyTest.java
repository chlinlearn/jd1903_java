package com.briup.event;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/10:00
 * @description: 体现观察者模式,事件模型
 */

public class BoyTest {
    public static void main(String[] args) {
        //创建事件源对象
        Girl girl = new Girl("lucy");
        //给事件源添加事件监听器
        girl.addEmotionListener(new EmotionListener() {
            @Override
            public void sad(EmotionEvent e) {
                System.out.println(e.getGirl().getName()+"在哭，男孩不开心");
            }

            @Override
            public void happy(EmotionEvent e) {
                System.out.println(e.getGirl().getName()+"在笑，男孩不开心");
            }
        });
        //产生事件
        girl.cry();
    }
}
