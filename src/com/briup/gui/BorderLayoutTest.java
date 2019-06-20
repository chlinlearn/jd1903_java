package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/9:50
 * @description: BorderLayout布局
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayoutTest extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton northBtn,southBtn,eastBtn,westBtn;
    private JButton[] btns = new JButton[100];
    //创建容器
    public BorderLayoutTest(){
        ImageIcon icon = new ImageIcon("src/com/briup/gui/icons/logo.png");
        setIconImage(icon.getImage());
        setTitle("测试");
        setSize(500,500);
        setLocation(200,200);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }

    //初始化布局
    public void initGui(){
        northBtn = new JButton("north");
        eastBtn = new JButton("east");
        westBtn = new JButton("west");
        southBtn = new JButton("south");
        northBtn.addActionListener(this);
        eastBtn.addActionListener(this);
        westBtn.addActionListener(this);
        southBtn.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (int i=0;i<btns.length;i++){
            btns[i] = new JButton(i+"");
            btns[i].addActionListener(this);
            panel.add(btns[i]);
        }
        //添加组件
        contentPane.add(northBtn,BorderLayout.NORTH);
        contentPane.add(eastBtn,BorderLayout.EAST);
        contentPane.add(southBtn,BorderLayout.SOUTH);
        contentPane.add(westBtn,BorderLayout.WEST);
        contentPane.add(panel,BorderLayout.CENTER);
    }
    //显示
    public void go(){
        //可见的
        setVisible(true);
    }

    //集中式处理事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取事件源
        Object source = e.getSource();
        /*System.out.println(((JButton)source).getText());*/
        if (source==northBtn){

        }else if (source==eastBtn){

        }else if (source==westBtn){

        }else if (source==southBtn){

        }else {
            //中间按钮
        }
    }

    public static void main(String[] args) {
        new BorderLayoutTest().go();
    }
}
