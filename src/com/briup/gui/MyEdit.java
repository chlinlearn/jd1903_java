package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/11:43
 * @description: 编辑器
 */

import com.sun.corba.se.impl.interceptors.PICurrent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyEdit extends JFrame implements ActionListener {
    private Container contentPane;
    //菜单对象
    private JMenu fileMenu,editMenu,helpMenu;
    //菜单栏对象
    private JMenuBar bar;
    //菜单项对象
    private JMenuItem openItem,saveItem,exitItem;
    private JMenuItem copyItem,pasteItem,cutItem;
    private JMenuItem aboutItem;

    //工具栏
    private JButton copyTool,pasteTool,cutTool;
    private JToolBar toolBar;

    //多行文本域
    private JTextArea area;

    //上下文菜单
    private JPopupMenu popupMenu;
    private JMenuItem pCopy,pPaste,pCut;

    //定时器
    private Timer timer;

    public MyEdit(){
        timer = new Timer(1000,this);
        timer.start();//启动

        ImageIcon icon = new ImageIcon("src/com/briup/gui/" +
                "icons/编辑器.png");
        setIconImage(icon.getImage());
        setTitle("编辑器");
        setSize(600,600);
        setLocation(700,260);
        //(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-getWidth()*2)/2,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-getHeight()*2)/2
        //设置界面大小不可改变
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }
    public void initGui(){
        Font font = new Font("楷体",Font.BOLD,25);
        //菜单
        bar = new JMenuBar();
        fileMenu = new JMenu("file");
        openItem = new JMenuItem("open");
        saveItem = new JMenuItem("save");
        exitItem = new JMenuItem("exit");
        bar.add(fileMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        //添加分割线
        fileMenu.addSeparator();
        fileMenu.setFont(font);

        editMenu = new JMenu("edit");
        copyItem = new JMenuItem("cpoy");
        pasteItem = new JMenuItem("pause");
        cutItem = new JMenuItem("cut");
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(cutItem);
        editMenu.setFont(font);
        bar.add(editMenu);

        helpMenu = new JMenu("help");
        aboutItem = new JMenuItem("about");
        helpMenu.add(aboutItem);
        helpMenu.setFont(font);
        bar.add(helpMenu);

        //工具栏
        toolBar = new JToolBar();
        copyTool = new JButton("copy");
        copyTool.setFont(font);
        pasteTool = new JButton("paste");
        pasteTool.setFont(font);
        cutTool = new JButton("cut");
        cutTool.setFont(font);
        toolBar.add(copyTool);
        toolBar.add(pasteTool);
        toolBar.add(cutTool);
        contentPane.add(toolBar,BorderLayout.NORTH);

        //多行文本域
        area = new JTextArea();
        area.setFont(font);
        //自动换行
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        //添加滚动条
        /*JScrollPane sPanel = new JScrollPane(area);*/
        JViewport port=new JViewport();
        port.add(area);
        JScrollPane sPanel = new JScrollPane(port);
        contentPane.add(sPanel);

        //上下文菜单
        popupMenu = new JPopupMenu();
        pCopy = new JMenuItem("复制");
        pCopy.setFont(font);
        pPaste = new JMenuItem("粘贴");
        pPaste.setFont(font);
        pCut = new JMenuItem("剪切");
        pCut.setFont(font);
        popupMenu.add(pCopy);
        popupMenu.add(pPaste);
        popupMenu.add(pCut);

        //按钮，菜单项添加事件
        addBtnListener(copyTool,pasteTool,cutTool);
        addItemListener(copyItem,pasteItem,cutItem,pCopy,
                pPaste,pCut,openItem,saveItem,exitItem,aboutItem);

        //文本域添加鼠标事件
        area.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //获取按下的键,1表示左键,3表示右键
                //System.out.println(e.getButton());
                if (e.getButton()==3){
                    //上下文菜单出现的位置
                    popupMenu.show(area,e.getX(),e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //把菜单栏加入到容器
        setJMenuBar(bar);
    }

    public void addBtnListener(JButton... btn){
        for (JButton b:btn){
            b.addActionListener(this);
        }
    }
    public void addItemListener(JMenuItem... item){
        for (JMenuItem i:item){
            i.addActionListener(this);
        }
    }


    public void go(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int time = 0;
        //定时器
        /*if (source==timer){
            time++;
            System.out.println("时间为："+time);
        }*/
        if (source==exitItem){
            System.exit(0);
        }
        if (source==aboutItem){
            JOptionPane.showMessageDialog(null,"这是一个编辑器");
        }

        if (source==pCopy||source==copyItem||source==copyTool){
            area.copy();
        }else if (source==pPaste||source==pasteItem||source==pasteTool){
            area.paste();
        }else if (source==pCut||source==cutItem||source==cutTool){
            area.cut();
        }
    }

    public static void main(String[] args) {
        new MyEdit().go();
    }
}
