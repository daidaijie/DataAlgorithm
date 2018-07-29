package com.weiyeli.Nowcoder.Wangyi.Qiuzhao_2018;

import java.util.Scanner;

/**
 * 魔法币
 *
 * 魔法机器1只能产生奇数，魔法机器2只能产生偶数
 * 从n不断按奇偶倒推回0就可以了
 */
public class MoFaBi {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            //奇数
            if ((n & 1) == 1) {
                n = (n - 1) / 2;
                sb.append("1");
            } else {
                n = (n - 2) / 2;
                sb.append("2");
            }
        }
        System.out.println(sb.reverse().toString());
    }

}
