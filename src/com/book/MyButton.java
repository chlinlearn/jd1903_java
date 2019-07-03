package com.book;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/10:29
 * @description: null
 */

import javax.swing.*;

public class MyButton extends JButton {
    private int row;
    private int col;

    public MyButton() {
    }

    public MyButton(String text) {
        super(text);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
