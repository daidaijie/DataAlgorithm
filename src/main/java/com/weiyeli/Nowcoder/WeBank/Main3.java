package com.weiyeli.Nowcoder.WeBank;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long res = 0;
        long i = a;
        while (i >= 0) {
            String s = Long.toBinaryString(i);
            char[] c = s.toCharArray();
            if (isHuiWen(c)) {
                res++;
                if (i>1)
                    i -= 2;
                else --i;
            }else --i;
        }

        System.out.println(res);
    }

    private static boolean isHuiWen(char[] a) {
        if (a.length <= 0 || a == null)
            return false;

        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            if (a[i] != a[j])
                return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }
}
