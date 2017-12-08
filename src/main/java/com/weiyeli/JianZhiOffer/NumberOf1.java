package com.weiyeli.JianZhiOffer;

/**
 * 二进制中1的个数
 */
public class NumberOf1 {

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-9));
    }
}
