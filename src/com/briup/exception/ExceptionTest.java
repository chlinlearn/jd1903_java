package com.briup.exception;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/19/9:35
 * @description: 测试异常
 */

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("-------start--------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a = 0;
        int b = 0;
        int k = 0;
        String str1=scanner.nextLine();
        System.out.println("请输入第二个数：");
        String str2=scanner.nextLine();
        try {
            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
        }catch (NumberFormatException e){
            System.out.println("输入数据不对！");
            System.exit(0);//0正常退出,非0就是异常退出
        }catch (Exception e){
            e.getMessage();
            System.out.println("其他异常....");
        }
        try {
            k=a/b;//除零异常,抛出异常
            System.out.println("出现异常时，这行代码不会执行！");
        }catch (ArithmeticException e){
            //处理异常
            System.out.println("除数不能为零"+e.getMessage());
            System.out.println("请重新输入第二个数：");
            String str3=scanner.nextLine();
            b = Integer.parseInt(str3);
            k=a/b;
        }finally {
            scanner.close();
        }
        System.out.println("k="+k);
        System.out.println("-------end--------");
    }
}
