package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/17:08
 * @description: TODO
 */

public class Account {
    private String accountNo;//卡号
    private double balance;//金额

    public Account(String accountNo,double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    //存钱,返回存钱金额
    public double deposit(double amt){
        synchronized (this){
            if (amt<=0){
                return 0;
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            double temp = balance;
            temp += amt;//在机器指令中对应多条指令;
            balance = temp;
            return amt;
        }
    }
    //取钱
    public double withdraw(double amt){
        synchronized (this){
            if (amt>balance||amt<=0){
                return 0;
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            double temp = balance;
            temp -= amt;
            balance = temp;
            return amt;
        }

    }

}
