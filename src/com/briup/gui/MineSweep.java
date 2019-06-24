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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private int bons = 20;//总雷数
    private int time = 0;//计时
    private MyButton[][] btns;
    private Timer timer;
    private JPanel bonPanel = new JPanel();
    ImageIcon iconSamll = new ImageIcon("src/com/briup/gui/images/" +
                          "smallIcon.png");

    public MineSweep(){
        timer = new Timer(1000,this);
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
        pack();//自适应大小,必须放在initGUI()下面
    }
    public void initGui(){
        Font fontMenu = new Font("楷体",Font.BOLD,20);
        Font fontItem = new Font("楷体",Font.BOLD,16);
        /*1.menu*/
        //菜单栏
        bar = new JMenuBar();
        gameMenu = new JMenu("游戏");
        gameMenu.setFont(fontMenu);
        helpMenu = new JMenu("帮助");
        helpMenu.setFont(fontMenu);
        bar.add(gameMenu);
        bar.add(helpMenu);
        setJMenuBar(bar);
        //菜单项
        juniorItem = new JMenuItem("初级");
        juniorItem.setFont(fontItem);
        middleItem = new JMenuItem("中级");
        middleItem.setFont(fontItem);
        seniorItem = new JMenuItem("高级");
        seniorItem.setFont(fontItem);
        gameMenu.add(juniorItem);
        gameMenu.add(middleItem);
        gameMenu.add(seniorItem);
        helpItem = new JMenuItem("说明");
        helpItem.setFont(fontItem);
        helpMenu.add(helpItem);
        addItemListener(juniorItem,middleItem,seniorItem,helpItem);

        /*2.north*/
        JPanel nPanel = new JPanel();
        nPanel.setLayout(new FlowLayout());
        startBtn = new JButton("start");
        mineIconLabel = new JLabel(new ImageIcon("src/com/briup/gui/images/" +
                "bombForLabel.gif"));
        mineDescLabel = new JLabel("剩余地雷:");
        mineCountLabel = new JLabel(bons+"");
        timeIconLabel = new JLabel(new ImageIcon("src/com/briup/gui/images/" +
                "clock2.png"));
        timeDescLabel = new JLabel("时间:");
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
        //初始化雷区
        initBth(row,col);

    }

    public void initBth(int row,int col){
        bonPanel.setLayout(new GridLayout(row,col));
        //初始化按钮
        btns = new MyButton[row+2][col+2];
        for (int i=0;i<btns.length;i++){
            for (int j=0;j<btns[i].length;j++){
                btns[i][j] = new MyButton();//继承了JButton
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
                            System.out.println("点击右键");
                        }
                    }
                });
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

    //布雷
    public void addLandMine(int bons){
        for (int i=0;i<bons;i++){
            int x = (int)(Math.random()*col+1);
            int y = (int)(Math.random()*row+1);
            btns[x][y].isBom = true;
        }
    }
    //添加JMenuItem事件监听器
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

    //显示按钮周围雷的数量
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
            //1.定时器
            timer.start();
            //2.布雷并可操作,创建布雷的方法
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
                //定时器关闭
                timer.stop();
                //弹出对话框
                btn.setIcon(new ImageIcon("src/com/briup/gui/images/"+
                        "bomb.png"));
                JOptionPane.showMessageDialog(this,"游戏失败，踩到雷了！");
                /*int op = JOptionPane.showConfirmDialog(this,"游戏失败,是否再来一局?","info",JOptionPane.YES_NO_CANCEL_OPTION);
                if (op == JOptionPane.YES_OPTION){
                    initBth(row,col);
                    time = 0;
                    pack();
                }else {
                    System.exit(0);
                }*/
            }else{
                System.out.println("不是雷...");
                showBonNumber(btn);
            }
        }
        //JMenuItem事件监听
        if (source == juniorItem){
            bonPanel.removeAll();
            bons = 20;
            row = 9;
            col = 9;
            mineCountLabel.setText(bons+"");
            initBth(row,col);
            pack();//自适应大小
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
            JOptionPane.showMessageDialog(this,"扫雷使用说明！");
            System.out.println("helpItem...");
        }
    }
}
