package com.weiyeli.Nowcoder.Wangyi.Chunzhao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int res = 0;

        if (k ==0) {
            System.out.println((n+1)*n);
            return;
        }

        res += (n-k)*(n-k+1)/2;

        for (int i = n; i >= 1; i--) {
            for (int j = i-1; j >= 1; j--) {
                if ((i % j) >= k)
                    res++;
            }
        }

        System.out.println(res);
    }
}
