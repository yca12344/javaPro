package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String details = "---------零钱通明细---------";

        double money = 0;
        double balanece = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String note = "";
        do{

            System.out.println("\n=========零钱通菜单=========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退     出");
            System.out.print("请选择（1-4）:");
            key = scanner.next();
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();
                    if (money <= 0){
                        System.out.println("收益入账金额需要大于0");
                        break;
                    }
                    balanece += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balanece;
                    break;
                case "3":
                    System.out.print("消费金额:");
                    money = scanner.nextDouble();
                    if (money <= 0 || money >balanece){
                        System.out.println("您的消费金额应该在 0-" + balanece);
                        break;
                    }
                    System.out.print("消费说明：");
                    note =scanner.next();

                    balanece -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" +sdf.format(date) + "\t" + balanece;
                    break;
                case "4":
                    String choice = "";
                    while(true){
                        System.out.println("你确定要退出吗? y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)){
                            break;
                        }
                    }
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择错误，请重新选择");
            }

        }while (loop);
        System.out.println("-----退出了零钱通项目-----");
    }
}
