package com.weiyeli.Nowcoder.Wangyi.Qiuzhao_2018;

import java.util.Scanner;

/**
 * 平均长度
 */
public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        char[] a = n.toCharArray();

        int count = 0;
        double res = 0.0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                count++;
            }
        }

        res = (double)a.length / (count+1);

        System.out.printf("%.2f\n", res);
    }
}
