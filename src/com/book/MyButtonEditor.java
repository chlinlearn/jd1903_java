package com.book;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/10:25
 * @description: 继承表结构的默认编辑器
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonEditor extends DefaultCellEditor{
    private MyButton button;

    public MyButtonEditor(MyButton button) {
        super(new JTextField());
        //button = new MyButton("借阅");
        this.button = button;
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyButton button = (MyButton)e.getSource();
                int r = button.getRow();
                int c = button.getCol();
                System.out.println("行"+r+",列"+c);
                JOptionPane.showMessageDialog(null,"借阅成功!");
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        /*if (isSelected){
            button.setBackground(Color.GREEN);
        }else {
            button.setBackground(Color.GRAY);
        }*/
        button.setRow(row);
        button.setCol(column);
        return button;
    }
}
