package com.weiyeli.QiuZhao.PDD;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputs = input.toCharArray();

        int k = inputs.length / 4;
        int rows = k + 1;
        int length = inputs.length;

        //首先输出第一行
        for (int i = 0; i < rows; i++) {
            System.out.print(inputs[i]);
        }

        System.out.println();

        int x = length - 1;
        int y = rows;
        //输出中间几行
        for (int i = 0; i < k - 1; i++) {
            System.out.print(inputs[x]);
            for (int j = 0; j < rows - 2; j++) {
                System.out.print(" ");
            }
            System.out.print(inputs[y]);
            x--;
            y++;
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = y; i <= x; i++) {
            sb.append(inputs[i]);
        }

        System.out.println(sb.reverse().toString());

    }
}
