package com.briup.enums;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/14:45
 * @description: TODO
 */
enum Operation{up,down,left,right;}

public class SwitchTest {
    public void change(Operation o){
        switch (o){
            case up:
                System.out.println("向上走....");
                break;
            case down:
                System.out.println("向下走....");
                break;
            case left:
                System.out.println("向左走....");
                break;
            case right:
                System.out.println("向右走....");
                break;
        }
    }

    public static void main(String[] args) {
        SwitchTest s = new SwitchTest();
        s.change(Operation.down);
        s.change(Operation.up);
        s.change(Operation.left);
        s.change(Operation.right);
    }
}
