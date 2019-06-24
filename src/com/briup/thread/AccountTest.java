package com.briup.thread;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/24/17:17
 * @description: TODO
 */

public class AccountTest extends Thread {
    private Account account;
    private String name;

    public AccountTest(String name,Account account){
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        //取钱
        double amt = account.deposit(1000);
        System.out.println(getName()+"从"+account.getAccountNo()+
                "账号里面取了"+amt+"钱"+",剩余金额"+account.getBalance()+"元");
    }

    public static void main(String[] args) {
        Account account = new Account("12345678",1000);
        Thread t1 = new AccountTest("boy",account);
        Thread t2 = new AccountTest("girl",account);
        t1.start();
        t2.start();
    }
}
