package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/20/10:20
 * @description: ????????,??????
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
    private int str = 0;//???????????????????
    private int num1 = 0;//???????????
    private int num2 = 0;//???????????
    private char op = ' ';//??????

    public GridLayoutTest(){
        ImageIcon icon = new ImageIcon("src/com/briup/gui/" +
                "icons/计算器.png");
        setIconImage(icon.getImage());
        setTitle("计算器");
        setSize(500,500);
        setLocation(200,200);
        //????????С??????
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        initGui();
    }
    public void initGui(){
        resultText = new JTextField();
        //???ù??????????
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setText("0");
        //???ò????
        resultText.setEditable(false);
        resultText.setBackground(Color.LIGHT_GRAY);
        //????????
        Font font = new Font("????",Font.BOLD,42);
        resultText.setFont(font);
        contentPane.add(resultText,BorderLayout.NORTH);

        //?м??????
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new GridLayout(4,4));
        for (int i=0;i<btns.length;i++){
            btns[i] = new JButton(i+"");
            btns[i].setFont(font);
            //?????????????
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

        //?????????????
        addListener(clearBtn,addBtn,minusBtn,mulBtn,divBtn,equalsBtn);
    }

    public void addListener(JButton... btn){
        for (JButton b:btn){
            b.addActionListener(this);
        }
    }

    public void go(){
        setVisible(true);
    }

    //??????д???
    @Override
    public void actionPerformed(ActionEvent e) {
        //???????
        Object source = e.getSource();
        if (source == clearBtn){
            resultText.setText("0");
        }else if (source == minusBtn){
            //????
            num1 = Integer.parseInt(resultText.getText());
            op = '-';
            resultText.setText("-");
        }else if (source == addBtn){
            //???
            num1 = Integer.parseInt(resultText.getText());
            op = '+';
            resultText.setText("+");
            //System.out.println(num1);
        }else if (source == mulBtn){
            //???
            num1 = Integer.parseInt(resultText.getText());
            op = '*';
            resultText.setText("*");

        }else if (source == divBtn){
            //????
            num1 = Integer.parseInt(resultText.getText());
            op = '/';
            resultText.setText("/");

        }else if (source == equalsBtn){
            int result = 0;
            num2 = Integer.parseInt(resultText.getText());
            switch (op){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    if (num2==0){
                        JOptionPane.showMessageDialog(null,"?????????0");
                    }
                    result = num1/num2;
                    break;
            }
            resultText.setText(result+"");
        }else {
            //??????
            String s = resultText.getText();
            if (s.equals("0")||s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
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
