package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/15:59
 * @description:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaDiShu extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton startBtn;
    private JComboBox<String> comboBox;
    private JLabel label_time,label_score,timeShowLabel,scoreShowLabel;
    private JButton[] btns = new JButton[9];
    private Timer timer;
    private Timer gradeTimer;
    private static int time = 10;
    private static int score = 0;
    private int old_index = 0;
    ImageIcon icon = new ImageIcon("src/com/briup/gui/" +
            "icons/game.png");
    ImageIcon img_mouse = new ImageIcon("src/com/briup/gui/" +
            "icons/mouse.png");

    public DaDiShu(){

        timer = new Timer(1000,this);

        gradeTimer = new Timer(1000,this);

        setIconImage(icon.getImage());
        setTitle("打地鼠");
        setSize(600,600);
        setLocation(600,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }
    public void initGui(){
        /*north*/
        Font font = new Font("楷体",Font.BOLD,20);

        comboBox = new JComboBox<String>();
        comboBox.addItem("初级");
        comboBox.addItem("中级");
        comboBox.addItem("高级");
        comboBox.setFont(font);

        label_time = new JLabel("时间:");
        label_time.setFont(font);
        label_score = new JLabel("得分:");
        label_score.setFont(font);
        timeShowLabel = new JLabel(" 10s ");
        timeShowLabel.setFont(font);
        scoreShowLabel = new JLabel("  0  ");
        scoreShowLabel.setFont(font);
        startBtn = new JButton("开始");
        startBtn.setBackground(Color.GREEN);
        startBtn.setFont(font);
        startBtn.addActionListener(this);
        //startBtn.setEnabled(false);
        JPanel nPanel = new JPanel();
        nPanel.add(comboBox);
        nPanel.add(label_time);
        nPanel.add(timeShowLabel);
        nPanel.add(label_score);
        nPanel.add(scoreShowLabel);
        nPanel.add(startBtn);
        contentPane.add(nPanel,BorderLayout.NORTH);

        /*center*/
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new GridLayout(3,3));
        for (int i=0;i<btns.length;i++){
            btns[i] = new JButton();
            btns[i].setBackground(Color.LIGHT_GRAY);
            btns[i].setEnabled(false);
            cPanel.add(btns[i]);
            btns[i].addActionListener(this);
        }
        contentPane.add(cPanel);
    }
    public void go(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==startBtn){
            timeShowLabel.setText(" 10s ");
            scoreShowLabel.setText("  0  ");
            if (comboBox.getSelectedItem().equals("初级")){
                gradeTimer.setDelay(750);
            }else if (comboBox.getSelectedItem().equals("中级")){
                gradeTimer.setDelay(500);
            }else {
                gradeTimer.setDelay(200);
            }
            timer.start();
            gradeTimer.start();
        }

        if(source==timer){
           if (time>0){
                time--;
                timeShowLabel.setText(" 0"+time+"s ");
           }else {
               timer.stop();
               gradeTimer.stop();
               JOptionPane.showMessageDialog(this,"游戏结束，总得分："+score);
               time = 10;
               score = 0;
           }
        }

        if (source==gradeTimer){
            int index = (int)(Math.random()*9);
            System.out.println("before:"+index);
            btns[index].setIcon(img_mouse);
            btns[index].setEnabled(true);
            System.out.println("after:"+index);
            old_index = index;
        }else {
            if (e.getSource()==btns[old_index]){
                score += 10;
                scoreShowLabel.setText(score+"  ");
                System.out.println("score:"+score);
            }
            for (int i=0;i<btns.length;i++){
                btns[i].setEnabled(false);
                btns[i].setIcon(null);
                btns[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public static void main(String[] args) {
        new DaDiShu().go();
    }
}


