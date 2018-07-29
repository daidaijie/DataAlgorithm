package com.weiyeli.Nowcoder.Wangyi.Qiuzhao_2018;

import java.util.Scanner;

public class XiangFanShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder(String.valueOf(n));
        StringBuilder sb1 = new StringBuilder(String.valueOf(n));

        System.out.println(Integer.valueOf(sb.toString()) + Integer.valueOf(sb1.reverse().toString()));
    }
}
