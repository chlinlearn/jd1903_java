package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/11:10
 * @description: 卡片布局
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutTest extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton firstBtn,threeBtn,lastBtn,preBtn,nextBtn;
    private JPanel cPanel = new JPanel();
    //标识卡片
    private String[] msg = {"one","two","three","four","five"};
    //卡片颜色
    private Color[] colors = {Color.pink,Color.GREEN,Color.BLUE,
            Color.CYAN,Color.ORANGE};
    //卡片布局对象
    private CardLayout card;

    public CardLayoutTest() {
        ImageIcon icon = new ImageIcon("src/com/briup/gui/icons/manager.png");
        setIconImage(icon.getImage());
        setTitle("轮播图");
        setSize(600,600);
        setLocation(200,200);
        //设置界面大小不可改变
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }
    public void initGui(){
        Font font = new Font("楷体",Font.BOLD,20);
        //south
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        threeBtn = new JButton("第三张");;
        preBtn = new JButton("前一张");
        nextBtn = new JButton("下一张");
        JPanel southPanel = new JPanel();
        southPanel.add(firstBtn);
        southPanel.add(lastBtn);
        southPanel.add(threeBtn);
        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        contentPane.add(southPanel,BorderLayout.SOUTH);
        addListener(firstBtn,lastBtn,threeBtn,preBtn,nextBtn);
        //center
        card = new CardLayout();
        cPanel.setLayout(card);
        for (int i=0;i<msg.length;i++){
            JButton btn = new JButton(i+1+"");
            btn.setBackground(colors[i]);
            //btn.addActionListener(this);
            //把卡片放在panel
            cPanel.add(msg[i],btn);
        }
        contentPane.add(cPanel);
    }

    public void go(){
        setVisible(true);
    }

    public void addListener(JButton... btn) {
        for (JButton b:btn){
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==firstBtn){
            card.first(cPanel);
        }else if (source==nextBtn){
            card.next(cPanel);
        }else if (source==preBtn){
            card.previous(cPanel);
        }else if (source==lastBtn){
            card.last(cPanel);
        }else if (source==threeBtn){
            card.show(cPanel,"three");
        }else {
            System.out.println("...");
        }
    }

    public static void main(String[] args) {
        new CardLayoutTest().go();
    }
}
