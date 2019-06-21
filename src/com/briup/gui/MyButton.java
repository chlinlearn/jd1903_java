package com.briup.gui;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/11:36
 * @description: TODO
 */

import javax.swing.*;

public class MyButton extends JButton {
    public int x;
    public int y;
    public boolean isBom;//是否是雷
    public boolean isClicked;//是否已经被点开
    public boolean isRight;//是否被右击

    public MyButton(){
        x = 0;
        y = 0;
        isBom = false;
        isRight = false;
        isClicked = true;
    }
}
