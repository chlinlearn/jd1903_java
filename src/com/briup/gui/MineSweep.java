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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private int bons = 20;//������
    private int time = 0;//��ʱ
    private MyButton[][] btns;
    private Timer timer;
    private JPanel bonPanel = new JPanel();
    ImageIcon iconSamll = new ImageIcon("src/com/briup/gui/images/" +
                          "smallIcon.png");

    public MineSweep(){
        timer = new Timer(1000,this);
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
        pack();//����Ӧ��С,�������initGUI()����
    }
    public void initGui(){
        Font fontMenu = new Font("����",Font.BOLD,20);
        Font fontItem = new Font("����",Font.BOLD,16);
        /*1.menu*/
        //�˵���
        bar = new JMenuBar();
        gameMenu = new JMenu("��Ϸ");
        gameMenu.setFont(fontMenu);
        helpMenu = new JMenu("����");
        helpMenu.setFont(fontMenu);
        bar.add(gameMenu);
        bar.add(helpMenu);
        setJMenuBar(bar);
        //�˵���
        juniorItem = new JMenuItem("����");
        juniorItem.setFont(fontItem);
        middleItem = new JMenuItem("�м�");
        middleItem.setFont(fontItem);
        seniorItem = new JMenuItem("�߼�");
        seniorItem.setFont(fontItem);
        gameMenu.add(juniorItem);
        gameMenu.add(middleItem);
        gameMenu.add(seniorItem);
        helpItem = new JMenuItem("˵��");
        helpItem.setFont(fontItem);
        helpMenu.add(helpItem);
        addItemListener(juniorItem,middleItem,seniorItem,helpItem);

        /*2.north*/
        JPanel nPanel = new JPanel();
        nPanel.setLayout(new FlowLayout());
        startBtn = new JButton("start");
        mineIconLabel = new JLabel(new ImageIcon("src/com/briup/gui/images/" +
                "bombForLabel.gif"));
        mineDescLabel = new JLabel("ʣ�����:");
        mineCountLabel = new JLabel(bons+"");
        timeIconLabel = new JLabel(new ImageIcon("src/com/briup/gui/images/" +
                "clock2.png"));
        timeDescLabel = new JLabel("ʱ��:");
        timeCountLabel = new JLabel(time+"");
        nPanel.add(mineIconLabel);
        nPanel.add(mineDescLabel);
        nPanel.add(mineCountLabel);
        nPanel.add(startBtn);
        nPanel.add(timeIconLabel);
        nPanel.add(timeDescLabel);
        nPanel.add(timeCountLabel);
        contentPane.add(nPanel,BorderLayout.NORTH);
        startBtn.addActionListener(this);

        /*3.center*/
        //��ʼ������
        initBth(row,col);

    }

    public void initBth(int row,int col){
        bonPanel.setLayout(new GridLayout(row,col));
        //��ʼ����ť
        btns = new MyButton[row+2][col+2];
        for (int i=0;i<btns.length;i++){
            for (int j=0;j<btns[i].length;j++){
                btns[i][j] = new MyButton();//�̳���JButton
                btns[i][j].setIcon(iconSamll);
                btns[i][j].addActionListener(this);
                final JButton btn = btns[i][j];
                btns[i][j].addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == 3){
                            ((MyButton) btn).isRight = true;
                            btn.setIcon(new ImageIcon("src/com/briup/gui/images/"+
                                    "flag_2.png"));
                            mineCountLabel.setText(--bons+"");
                            System.out.println("����Ҽ�");
                        }
                    }
                });
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

    //����
    public void addLandMine(int bons){
        for (int i=0;i<bons;i++){
            int x = (int)(Math.random()*col+1);
            int y = (int)(Math.random()*row+1);
            btns[x][y].isBom = true;
        }
    }
    //���JMenuItem�¼�������
    public void addItemListener(JMenuItem... items){
        for (JMenuItem item:items){
            item.addActionListener(this);
        }
    }

    public void switchFunc(int n,MyButton btn){
        switch (n){
            case 1:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/1.png"));
                //btn.setEnabled(false);
                break;
            case 2:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/2.png"));
                //btn.setEnabled(false);
                break;
            case 3:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/3.png"));
                //btn.setEnabled(false);
                break;
            case 4:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/4.png"));
                //btn.setEnabled(false);
                break;
            case 5:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/5.png"));
                //btn.setEnabled(false);
                break;
            case 6:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/6.png"));
                //btn.setEnabled(false);
                break;
            case 7:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/7.png"));
                //btn.setEnabled(false);
                break;
            case 8:
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/8.png"));
                //btn.setEnabled(false);
                break;
        }
    }

    //��ʾ��ť��Χ�׵�����
    public void showBonNumber(MyButton btn){
        int count = 0;
        int subCount = 0;
        btn.isClicked = true;
        for (int i=btn.x-1;i<btn.x+2;i++){
            for (int j=btn.y-1;j<btn.y+2;j++){
                if (btns[i][j].isBom){
                    count++;
                }/*else {
                    for (int m=btns[i][j].x-1;m<btns[i][j].x+2;m++){
                        for (int n=btns[i][j].y-1;n<btns[i][j].y+2;n++){
                            if (btns[m][n].isBom){
                                subCount++;
                            }
                        }
                    }*/
                    //btns[i][j].isClicked = true;
                    /*if (subCount==0){
                        for (int m=btns[i][j].x-1;m<btns[i][j].x+2;m++){
                            for (int n=btns[i][j].y-1;n<btns[i][j].y+2;n++){
                                if (btns[m][n].isRight||btns[m][n].isClicked){
                                    if (btns[m][n].getIcon()== iconSamll){
                                        btns[m][n].setIcon(new ImageIcon("src/com/briup/gui.images/0.png"));
                                        btns[m][n].setEnabled(false);
                                    }
                                    continue;
                                }
                                btns[m][n].setIcon(new ImageIcon("src/com/briup/gui.images/0.png"));
                                btns[m][n].setEnabled(false);
                            }
                        }
                    }
                    switchFunc(subCount,btns[i][j]);
                }*/
            }
        }
        if (count==0){
            for (int i=btn.x-1;i<btn.x+2;i++){
                for (int j=btn.y-1;j<btn.y+2;j++){
                    if (btns[i][j].isRight||btns[i][j].isClicked){
                        if (btns[i][j].getIcon()== iconSamll){
                            System.out.println("0");
                            btns[i][j].setIcon(new ImageIcon("src/com/briup/gui.images/0.png"));
                            btns[i][j].setEnabled(false);
                        }
                        continue;
                    }
                    btns[i][j].setIcon(new ImageIcon("src/com/briup/gui.images/0.png"));
                    btns[i][j].setEnabled(false);
                }
            }
        }
        switchFunc(count,btn);
    }

    public static void main(String[] args) {
        new MineSweep().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == startBtn){
            //1.��ʱ��
            timer.start();
            //2.���ײ��ɲ���,�������׵ķ���
            for (int i=1;i<=col;i++){
                for (int j=1;j<=row;j++){
                    btns[i][j].setEnabled(true);
                }
            }
            addLandMine(bons);
        }

        if (timer.isRunning()){
            time++;
            timeCountLabel.setText(" "+time);
        }

        if (source instanceof MyButton){
            MyButton btn = (MyButton) source;
            if (btn.isBom){
                //��ʱ���ر�
                timer.stop();
                //�����Ի���
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/"+
                        "bomb.png"));
                JOptionPane.showMessageDialog(this,"��Ϸʧ�ܣ��ȵ����ˣ�");
                /*int op = JOptionPane.showConfirmDialog(this,"��Ϸʧ��,�Ƿ�����һ��?","info",JOptionPane.YES_NO_CANCEL_OPTION);
                if (op == JOptionPane.YES_OPTION){
                    initBth(row,col);
                    time = 0;
                    pack();
                }else {
                    System.exit(0);
                }*/
            }else{
                System.out.println("������...");
                showBonNumber(btn);
            }
        }
        //JMenuItem�¼�����
        if (source == juniorItem){
            bonPanel.removeAll();
            bons = 20;
            row = 9;
            col = 9;
            mineCountLabel.setText(bons+"");
            initBth(row,col);
            pack();//����Ӧ��С
            System.out.println("juniorItem...");
        }else if (source == middleItem){
            bonPanel.removeAll();
            bons = 40;
            row = 16;
            col = 16;
            mineCountLabel.setText(bons+"");
            initBth(row,col);
            pack();
            System.out.println("middleItem...");
        }else if (source == seniorItem){
            bonPanel.removeAll();
            bons = 80;
            row = 24;
            col = 24;
            mineCountLabel.setText(bons+"");
            initBth(row,col);
            pack();
            System.out.println("seniorItem...");
        }else if (source == helpItem){
            JOptionPane.showMessageDialog(this,"ɨ��ʹ��˵����");
            System.out.println("helpItem...");
        }
    }
}
