package com.weiyeli.Nowcoder.Tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int lengthA = in.nextInt();
        int countA = in.nextInt();
        int lengthB = in.nextInt();
        int countB = in.nextInt();

        long res = 0;

        if (lengthA == k) {
            System.out.println(countA);
            return;
        }

        if (lengthB == k) {
            System.out.println(countB);
            return;
        }

        if (lengthA > k && lengthB > k) {
            System.out.println(0);
            return;
        }

        if (lengthA > k && lengthB < k) {
            if (k % lengthB == 0) {
                int temp = k / lengthB;
                long shang = 0;
                long xia = 0;
                for (int i = countB; i > countB - temp + 1; i--) {
                    shang *= i;
                }
                for (int i = temp; i > 0; i--) {
                    shang *= i;
                }
                res = shang / temp;
            }
        }

        if (lengthA < k && lengthB > k) {
            if (k % lengthA == 0) {
                int temp = k / lengthA;
                long shang = 0;
                long xia = 0;
                for (int i = countA; i > countA - temp + 1; i--) {
                    shang *= i;
                }
                for (int i = temp; i > 0; i--) {
                    shang *= i;
                }
                res = shang / temp;
            }
        }

        if (isOk(k,lengthA,lengthB)) {
            res =
        }


        System.out.println(res % 1000000007);
    }

    private static boolean isOk(int k, int a, int b) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (i*k+j*b == k)
                    return true;
            }
        }

        return false;
    }
}
