package com.book;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/2/10:16
 * @description: 借阅模块GUI实现
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorrowBackGui extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton allBtn,borrowedBtn,backedBtn,searchBtn,indexBtn;
    private JLabel userIdLab,usernameLab,genderLab,ageLab,noReturnLab;
    private JTextField inputText;
    private CardLayout card;
    private DefaultTableModel model = null;
    private JPanel showPanel;


    public BorrowBackGui(){
        setTitle("借阅管理");
        setSize(800,600);
        int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation((x-this.getWidth())/2,(y-this.getHeight())/2);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        initGui();
        pack();
    }

    public void initGui(){
        Font font = new Font("楷体",Font.BOLD,20);
        //用户信息
        userIdLab = new JLabel("用户ID：");
        userIdLab.setFont(font);
        usernameLab = new JLabel("用户名：");
        usernameLab.setFont(font);
        genderLab = new JLabel("性别：");
        genderLab.setFont(font);
        ageLab = new JLabel("年龄：");
        ageLab.setFont(font);
        noReturnLab = new JLabel("未归还：");
        noReturnLab.setFont(font);

        //按钮区,搜索区
        indexBtn = new JButton("返回首页");
        indexBtn.setFont(font);
        indexBtn.setBackground(Color.LIGHT_GRAY);
        indexBtn.addActionListener(this);
        allBtn = new JButton("全部");
        allBtn.setFont(font);
        allBtn.addActionListener(this);
        allBtn.setBackground(Color.LIGHT_GRAY);
        borrowedBtn = new JButton("已借阅");
        borrowedBtn.setFont(font);
        borrowedBtn.setBackground(Color.LIGHT_GRAY);
        borrowedBtn.addActionListener(this);
        backedBtn = new JButton("已归还");
        backedBtn.setFont(font);
        backedBtn.setBackground(Color.LIGHT_GRAY);
        backedBtn.addActionListener(this);
        searchBtn = new JButton("搜索");
        searchBtn.setFont(font);
        searchBtn.setBackground(Color.LIGHT_GRAY);
        searchBtn.addActionListener(this);
        inputText = new JTextField("请输入要查询的书名或编号");
        inputText.setColumns(20);
        inputText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1){
                    inputText.setText("");
                }
            }
        });

        JPanel userPanel = new JPanel(new BorderLayout());
        JPanel nPanel = new JPanel(new GridLayout(2,3,1,15));
        JPanel sPanel = new JPanel(new GridLayout(2,3,5,15));
        nPanel.add(userIdLab);
        nPanel.add(usernameLab);
        nPanel.add(genderLab);
        nPanel.add(ageLab);
        nPanel.add(noReturnLab);

        sPanel.add(indexBtn);
        sPanel.add(inputText);
        sPanel.add(searchBtn);
        sPanel.add(allBtn);
        sPanel.add(borrowedBtn);
        sPanel.add(backedBtn);
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,nPanel,sPanel);
        //splitPane.setDividerLocation(10);
        userPanel.add(splitPane,BorderLayout.NORTH);

        //图书信息展示
        String[][] searchData = new String[20][5];
        for (int i=0;i<20;i++){
            for (int j=0;j<5;j++){
                if (j==4){
                    searchData[i][j] = "借阅";
                }
                searchData[i][j] = i+""+j;
            }
        }
        String[][] allData = new String[20][8];
        for (int i=0;i<20;i++){
            for (int j =0;j<8;j++){
                allData[i][j] = i+""+j;
            }
        }

        String[] title = {"书名","作者","出版社","定价","借书时间","到期时间","是否续借","是否归还"};
        String[] searchTableTitle = {"书名","出版社","定价","作者","操作"};
        JTable allTable = new JTable(new DefaultTableModel(allData,title));
        allTable.setRowHeight(36);
        //allTable.setEnabled(false);
        //allTable.setRowMargin(20);
        JTable borrowedTable = new JTable(new DefaultTableModel(allData,title));
        borrowedTable.setRowHeight(36);
        JTable backedTable = new JTable(new DefaultTableModel(allData,title));
        backedTable.setRowHeight(36);
        JTable searchTable = new JTable(new DefaultTableModel(searchData,searchTableTitle));
        searchTable.setRowHeight(36);

        MyButton button = new MyButton("借阅");
        button.setBackground(Color.LIGHT_GRAY);
        //设置表格的渲染器
        searchTable.getColumnModel().getColumn(4).setCellRenderer(new MyButtonRender(button));
        //设置表格的编辑器
        //禁止掉JTable的行选中功能。否则我们再点击按钮时，JTable不知道是响应为'行选中'还是'按钮单击事件'。
        //searchTable.setRowSelectionAllowed(false);
        searchTable.getColumnModel().getColumn(4).setCellEditor(new MyButtonEditor(button));

        card = new CardLayout();
        showPanel = new JPanel(card);
        showPanel.add("allBtn",new JScrollPane(allTable));
        showPanel.add("searchBtn",new JScrollPane(searchTable));
        showPanel.add("borrowedBtn",new JScrollPane(borrowedTable));
        showPanel.add("backedBtn",new JScrollPane(backedTable));

        //添加用户信息,伪数据
        userIdLab.setText(userIdLab.getText()+"123456");
        usernameLab.setText(usernameLab.getText()+"xxx");
        genderLab.setText(genderLab.getText()+"男");
        ageLab.setText(ageLab.getText()+"18");
        noReturnLab.setText(noReturnLab.getText()+"0");

        //添加到大桌布
        contentPane.add(userPanel,BorderLayout.NORTH);
        contentPane.add(showPanel,BorderLayout.SOUTH);
    }

    public void go(){
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorrowBackGui().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==allBtn){
            card.show(showPanel,"allBtn");
        }
        if (source==searchBtn){
            card.show(showPanel,"searchBtn");
        }
        if (source==borrowedBtn){
            card.show(showPanel,"borrowedBtn");
        }
        if (source==backedBtn){
            card.show(showPanel,"backedBtn");
        }
        if (source==indexBtn){
            System.out.println("返回首页");
            JOptionPane.showConfirmDialog(this,"返回首页");
        }
    }
}
