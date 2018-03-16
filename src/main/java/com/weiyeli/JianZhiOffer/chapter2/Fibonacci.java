package com.weiyeli.JianZhiOffer.chapter2;

/**
 * 斐波那契数列
 */
public class Fibonacci {


    public static int Fibonacci(int n) {

        if (n <= 0)
            return 0;

        int[] a = new int[40];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }


}
