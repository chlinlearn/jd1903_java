package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/10:20
 * @description: 网格布局测试,计算器
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutTest extends JFrame implements ActionListener {
    private Container contentPane;
    private JTextField resultText;
    private JButton[] btns = new JButton[10];
    private JButton clearBtn,addBtn,minusBtn,divBtn,mulBtn,equalsBtn;

    public GridLayoutTest(){
        ImageIcon icon = new ImageIcon("src/com/briup/gui/icons/manager.png");
        setIconImage(icon.getImage());
        setTitle("计算器");
        setSize(500,500);
        setLocation(200,200);
        //设置界面大小不可改变
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }
    public void initGui(){
        resultText = new JTextField();
        //设置光标文本右对齐
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setText("0");
        //设置不可编辑
        resultText.setEditable(false);
        resultText.setBackground(Color.pink);
        //设置字体
        Font font = new Font("楷体",Font.BOLD,42);
        resultText.setFont(font);
        contentPane.add(resultText,BorderLayout.NORTH);

        //中间按钮部分
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new GridLayout(4,4));
        for (int i=0;i<btns.length;i++){
            btns[i] = new JButton(i+"");
            btns[i].setFont(font);
            //为按钮添加监听事件
            btns[i].addActionListener(this);
            cPanel.add(btns[i]);
        }
        clearBtn = new JButton("C");
        clearBtn.setFont(font);
        addBtn = new JButton("+");
        addBtn.setFont(font);
        minusBtn = new JButton("-");
        minusBtn.setFont(font);
        mulBtn = new JButton("*");
        mulBtn.setFont(font);
        divBtn = new JButton("/");
        divBtn.setFont(font);
        equalsBtn = new JButton("=");
        equalsBtn.setFont(font);
        contentPane.add(cPanel);
        cPanel.add(clearBtn);
        cPanel.add(minusBtn);
        cPanel.add(addBtn);
        cPanel.add(mulBtn);
        cPanel.add(divBtn);
        cPanel.add(equalsBtn);

        //为按钮添加监听事件
        addListener(clearBtn,addBtn,minusBtn,mulBtn,divBtn,equalsBtn);
        /*clearBtn.addActionListener(this);
        addBtn.addActionListener(this);
        minusBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        equalsBtn.addActionListener(this);*/

    }

    public void addListener(JButton... btn){
        for (JButton b:btn){
            b.addActionListener(this);
        }
    }

    public void go(){
        setVisible(true);
    }

    //事件集中处理
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取事件源
        Object source = e.getSource();
        if (source == clearBtn){
            resultText.setText("0");
        }else if (source == minusBtn){

        }else if (source == addBtn){

        }else if (source == mulBtn){

        }else if (source == divBtn){

        }else if (source == equalsBtn){

        }else {
            //数字按钮
            String s = resultText.getText();
            if (s.equals("0")){
                resultText.setText(((JButton)source).getText());
            } else {
                resultText.setText(s+((JButton)source).getText());
            }
        }
    }

    public static void main(String[] args) {
        new GridLayoutTest().go();
    }
}
