package com.weiyeli.Nowcoder.Wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 洗牌
 */
public class Shuffle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] input = new int[2 * n];
            // 辅助数组
            int[] aux = new int[2 * n];
            for (int i = 0; i < input.length; i++) {
                input[i] = scanner.nextInt();
            }

            // 洗牌k次
            while (k-- > 0) {
                int mid = (input.length - 1) / 2;
                int i = mid;
                int j = input.length - 1;
                int l = input.length - 1;
                while (j > mid) {
                    aux[l--] = input[j--];
                    aux[l--] = input[i--];
                }
                input = Arrays.copyOf(aux, 2 * n);
            }

            for (int i = 0; i < aux.length; i++) {
                if (i == aux.length - 1)
                    System.out.println(aux[i]);
                else System.out.print(aux[i] + " ");
            }
        }
    }
}
