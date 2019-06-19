package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:44
 * @description: GUI图形化界面
 */
import javax.swing.*;
import java.awt.*;

public class MyFirstGui {
    //桌子
    private JFrame frame;
    //桌布
    private Container contentPanel;

    //构造器对容器初始化
    public MyFirstGui(){
        frame = new JFrame();
        frame.setSize(500,200);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("计算器");
        //frame.setBackground(Color.BLUE);
        //设置背景颜色
        contentPanel = frame.getContentPane();
        Color color = new Color(2.0f,3.0f,4.0f);
        contentPanel.setBackground(Color.BLUE);
    }

    //对组件进行初始化，并把组件添加到容器中
    public void initGui(){

    }
    //显示界面
    public void go(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFirstGui().go();
    }
}
