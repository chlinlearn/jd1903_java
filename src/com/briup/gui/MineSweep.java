package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/11:16
 * @description: 扫雷游戏
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweep extends JFrame implements ActionListener {
    private Container contentPane;
    private JMenuBar bar;//菜单栏对象
    private JMenu gameMenu,helpMenu;//菜单对象
    private JMenuItem juniorItem,middleItem,seniorItem,helpItem;//菜单项对象
    private JLabel mineIconLabel,mineDescLabel,mineCountLabel,
            timeIconLabel,timeDescLabel,timeCountLabel;
    private JButton startBtn;
    private int row = 9;//行
    private int col = 9;//列
    private int bons = 10;//总雷数
    private MyButton[][] btns;

    public MineSweep(){
        ImageIcon icon = new ImageIcon("src/com/briup/gui/images/" +
                "地雷.png");
        setIconImage(icon.getImage());
        setTitle("扫雷游戏");
        setSize(600,600);
        setLocation(600,300);
        //设置界面大小不可改变
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();//获取幕布
        contentPane.setLayout(new BorderLayout());
        initGui();
        pack();//必须放在initGUI()下面
    }
    public void initGui(){
        //1.menu
        //2.north
        startBtn = new JButton("start");
        contentPane.add(startBtn,BorderLayout.NORTH);
        startBtn.addActionListener(this);
        //3.center
        //初始化雷区
        initBth(row,col);

    }

    public void initBth(int row,int col){
        JPanel bonPanel = new JPanel();
        bonPanel.setLayout(new GridLayout(row,col));
        //初始化按钮
        btns = new MyButton[row+2][col+2];
        for (int i=0;i<btns.length;i++){
            for (int j=0;j<btns[i].length;j++){
                btns[i][j] = new MyButton();//继承了JButton
                btns[i][j].setIcon(new ImageIcon("src/com/briup/gui/images/" +
                        "smallIcon.png"));
                btns[i][j].addActionListener(this);
                //取消组件间距
                btns[i][j].setMargin(new Insets(0,0,0,0));
                btns[i][j].isClicked = false;
                btns[i][j].x = i;
                btns[i][j].y = j;
                btns[i][j].isBom = false;
                btns[i][j].setEnabled(false);
            }
        }
        //将按钮放到panel
        for (int i=1;i<btns.length-1;i++){
            for (int j = 1;j<btns[i].length-1;j++){
                bonPanel.add(btns[i][j]);
            }
        }
        contentPane.add(bonPanel);
    }

    public void go(){
        setVisible(true);
    }
    public void addLandMine(int bons){
        for (int i=0;i<bons;i++){
            int x = (int)(Math.random()*col+1);
            int y = (int)(Math.random()*row+1);
            btns[x][y].isBom = true;
        }
    }

    public static void main(String[] args) {
        new MineSweep().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == startBtn){
            //1.定时器
            //2.布雷并可操作,创建布雷的方法
            for (int i=1;i<=col;i++){
                for (int j=1;j<=row;j++){
                    btns[i][j].setEnabled(true);
                }
            }
            addLandMine(bons);
        }
        if (source instanceof MyButton){
            MyButton btn = (MyButton) source;
            if (btn.isBom){
                //定时器关闭
                //弹出对话框
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/"+
                        "bomb.png"));
                System.out.println("踩到了雷...");
            }else{
                System.out.println("不是雷...");
                //showBonNumber(btn);
            }
        }
    }
}
