package com.xu;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        int i = 0;
        int k;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个大于零的整数：\n");
        k = scanner.nextInt();
        for(;i <= k;i++){
            System.out.println(i);
        }
        System.out.println("程序结束");
    }
}
