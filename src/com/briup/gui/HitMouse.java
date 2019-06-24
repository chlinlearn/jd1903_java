package com.briup.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HitMouse extends JFrame implements ActionListener{

    private JLabel timeLabel,timeValueLabel,centLabel,centValueLabel;
    private JButton startButton;
    private JComboBox<String> box;
    private JButton[] btns;
    private JPanel north,center;
    //控制游戏计时器
    private Timer timer;
    //控制老鼠出现计时器
    private Timer mouseTimer;
    private int level;
    //用来展示老鼠图片
    private ImageIcon icon;
    //上次老鼠出现的位置
    private int old_index;
    private boolean flag;

    public HitMouse() {
        this.setTitle("打地鼠");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize()
                        .getWidth()-this.getWidth())/2,
                (int)(Toolkit.getDefaultToolkit().getScreenSize()
                        .getHeight()-this.getHeight())/2);
        this.setResizable(false);
        init();
        this.setVisible(true);

    }

    public void init() {
        north=new JPanel();
        center=new JPanel();
        timeLabel=new JLabel("time:");
        timeValueLabel=new JLabel("10");
        centLabel=new JLabel("cent:");
        centValueLabel=new JLabel("0");
        startButton=new JButton("开始");
        box=new JComboBox<>();
        box.addItem("初级");
        box.addItem("中级");
        box.addItem("高级");
        icon=new ImageIcon("src/com/briup/gui/icons/mouse.png");
        btns=new JButton[9];

        center.setLayout(new GridLayout(3, 3));
        for(int i=0;i<btns.length;i++) {
            btns[i]=new JButton();
            btns[i].setEnabled(false);
            center.add(btns[i]);
        }

        //设置布局，添加组件
        north.add(timeLabel);
        north.add(timeValueLabel);
        north.add(box);
        north.add(centLabel);
        north.add(centValueLabel);
        north.add(startButton);

        this.setLayout(new BorderLayout());
        this.add(north,BorderLayout.NORTH);
        this.add(center,BorderLayout.CENTER);

        //添加事件监听
        startButton.addActionListener(this);
        box.addActionListener(this);
        for(int i=0;i<btns.length;i++) {
            btns[i].addActionListener(this);
        }


        timer=new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = timeValueLabel.getText();
                int time = Integer.parseInt(text);
                timeValueLabel.setText(--time+"");
                if(time==0) {
                    timer.stop();
                    mouseTimer.stop();
                    startButton.setEnabled(true);
                    box.setEnabled(true);
                    setAllBtnsEnable(false);
                    btns[old_index].setIcon(null);
                }

            }
        });

        level=1000;
        mouseTimer=new Timer(level,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btns[old_index].setIcon(null);
                int index=(int)(Math.random()*9);
                btns[index].setIcon(icon);
                flag=true;
                old_index=index;
            }
        });

    }

    public void setAllBtnsEnable(Boolean b) {
        for(int i=0;i<btns.length;i++) {
            btns[i].setEnabled(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==startButton) {
            timeValueLabel.setText("10");
            centValueLabel.setText("0");
            timer.start();
            mouseTimer.start();
            startButton.setEnabled(false);
            setAllBtnsEnable(true);
            box.setEnabled(false);
        }else if(source==box) {
            int index = box.getSelectedIndex();
            if(index==1) {
                level=500;
            }else if(index==2) {
                level=200;
            }else {
                level=1000;
            }
            mouseTimer.setDelay(level);
        }else {
            JButton btn=(JButton)source;
            if(btn.getIcon()!=null&&flag) {
                String text = centValueLabel.getText();
                int cent = Integer.parseInt(text);
                centValueLabel.setText(++cent+"");
                flag=false;
            }
        }
    }

    public static void main(String[] args) {
        new HitMouse();
    }


}

