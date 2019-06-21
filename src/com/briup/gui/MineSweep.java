package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/11:16
 * @description: ɨ����Ϸ
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweep extends JFrame implements ActionListener {
    private Container contentPane;
    private JMenuBar bar;//�˵�������
    private JMenu gameMenu,helpMenu;//�˵�����
    private JMenuItem juniorItem,middleItem,seniorItem,helpItem;//�˵������
    private JLabel mineIconLabel,mineDescLabel,mineCountLabel,
            timeIconLabel,timeDescLabel,timeCountLabel;
    private JButton startBtn;
    private int row = 9;//��
    private int col = 9;//��
    private int bons = 10;//������
    private MyButton[][] btns;

    public MineSweep(){
        ImageIcon icon = new ImageIcon("src/com/briup/gui/images/" +
                "����.png");
        setIconImage(icon.getImage());
        setTitle("ɨ����Ϸ");
        setSize(600,600);
        setLocation(600,300);
        //���ý����С���ɸı�
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();//��ȡĻ��
        contentPane.setLayout(new BorderLayout());
        initGui();
        pack();//�������initGUI()����
    }
    public void initGui(){
        //1.menu
        //2.north
        startBtn = new JButton("start");
        contentPane.add(startBtn,BorderLayout.NORTH);
        startBtn.addActionListener(this);
        //3.center
        //��ʼ������
        initBth(row,col);

    }

    public void initBth(int row,int col){
        JPanel bonPanel = new JPanel();
        bonPanel.setLayout(new GridLayout(row,col));
        //��ʼ����ť
        btns = new MyButton[row+2][col+2];
        for (int i=0;i<btns.length;i++){
            for (int j=0;j<btns[i].length;j++){
                btns[i][j] = new MyButton();//�̳���JButton
                btns[i][j].setIcon(new ImageIcon("src/com/briup/gui/images/" +
                        "smallIcon.png"));
                btns[i][j].addActionListener(this);
                //ȡ��������
                btns[i][j].setMargin(new Insets(0,0,0,0));
                btns[i][j].isClicked = false;
                btns[i][j].x = i;
                btns[i][j].y = j;
                btns[i][j].isBom = false;
                btns[i][j].setEnabled(false);
            }
        }
        //����ť�ŵ�panel
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
            //1.��ʱ��
            //2.���ײ��ɲ���,�������׵ķ���
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
                //��ʱ���ر�
                //�����Ի���
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/"+
                        "bomb.png"));
                System.out.println("�ȵ�����...");
            }else{
                System.out.println("������...");
                //showBonNumber(btn);
            }
        }
    }
}
