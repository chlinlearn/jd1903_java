package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/25/16:41
 * @description: 优先级测试
 */

import javafx.beans.property.SetProperty;

public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        //设置优先级
        Thread.currentThread().setPriority(6);
        System.out.println(Thread.currentThread().getPriority());
    }
}
