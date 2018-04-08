package com.weiyeli.HDU;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (k-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            long res = 0;

            if (m == 0) {
                res = sum(0, n);
            } else {
                int index = -1;
                for (int i = 0; i < m; i++) {
                    if (a[i] == 1) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    res = sum(index + 1, n);
                } else {
                    res = sum(m, n);
                }

            }

            System.out.println(res + " RMB");
        }
    }


    private static long sum(int begin, int end) {
        int k = 10000;
        long res = 0;
        for (int i = begin; i < end; i++) {
            res += k;
            k *= 2;
        }

        return res;
    }
}
