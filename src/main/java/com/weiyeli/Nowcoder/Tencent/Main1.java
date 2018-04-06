package com.weiyeli.Nowcoder.Tencent;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if (n==1) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        boolean fu = true;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j == m) {
                fu = !fu;
                j = 0;
            }
            if (fu) {
                sum += -i;
                j++;
            } else {
                sum += i;
                j++;
            }
        }

        System.out.println(sum);
    }
}
