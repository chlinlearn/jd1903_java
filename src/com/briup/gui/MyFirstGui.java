package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/11:44
 * @description: GUI图形化界面
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class MyFirstGui {
    //桌子
    private JFrame frame;
    //桌布
    private Container contentPanel;
    //定义组件
    private JTextField numText1,numText2,numText3;
    private JLabel addLb,equalsLb;
    private JButton addBtn,clearBtn,exitBtn;

    //构造器对容器初始化
    public MyFirstGui(){
        frame = new JFrame();
        frame.setSize(500,200);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("计算器");
        //frame.setBackground(Color.BLUE);
        //创建布局容器
        contentPanel = frame.getContentPane();
        //设置背景颜色
        //Color color = new Color(2.0f,3.0f,4.0f);
        contentPanel.setBackground(Color.GREEN);
        //contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setLayout(new FlowLayout());
        initGui();
        //添加组件之后，作用是根据组件自动扩充容器
        //frame.pack();
    }

    //对组件进行初始化，并把组件添加到容器中
    public void initGui(){
        //创建组件
        numText1 = new JTextField(12);
        numText2 = new JTextField(12);
        numText3 = new JTextField(10);
        //设置第1,2个输入框不可输入非数字
        numText1.addKeyListener(new MyKeyListener());
        numText2.addKeyListener(new MyKeyListener());
        //设置第三个输入框不可输入
        //numText3.setEnabled(false);
        numText3.setEditable(false);
        //设置光标右对齐
        numText1.setHorizontalAlignment(JTextField.RIGHT);
        numText2.setHorizontalAlignment(JTextField.RIGHT);
        numText3.setHorizontalAlignment(JTextField.RIGHT);
        addLb = new JLabel("+");
        equalsLb = new JLabel("=");
        addBtn = new JButton("计算");
        clearBtn = new JButton("清空");
        exitBtn = new JButton("退出");
        //添加组件到容器
        contentPanel.add(numText1);
        contentPanel.add(addLb);
        contentPanel.add(numText2);
        contentPanel.add(equalsLb);
        contentPanel.add(numText3);
        contentPanel.add(addBtn);
        contentPanel.add(clearBtn);
        contentPanel.add(exitBtn);

        //给组件添加事件
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //trim()去两边的空格
                String s1 = numText1.getText().trim();
                String s2 = numText2.getText().trim();
                if (s1.equals("")||s2.equals("")){
                    JOptionPane.showConfirmDialog(null,"不能为空");
                    return;
                }
                //正则判断数字
                Pattern pattern = Pattern.compile("[0-9]*");
                if(pattern.matcher(s1).matches()&&pattern.matcher(s2).matches()){
                    int sum = Integer.parseInt(s1)+Integer.parseInt(s2);
                    numText3.setText(sum+"");
                }else{
                    numText1.setText("");
                    numText2.setText("");
                    JOptionPane.showConfirmDialog(null,"请输入数字！");
                }
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //置空
                numText1.setText("");
                numText2.setText("");
                numText3.setText("");
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //显示界面
    public void go(){
        frame.setVisible(true);
    }

    class MyKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped....");
            //获取键的hashcode
            int code = e.getKeyChar();
            System.out.println(code);
            if (code>57||code<48){
                //阻止输入非数字
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed....");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased....");
        }
    }

    public static void main(String[] args) {
        new MyFirstGui().go();
    }
}
