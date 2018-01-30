package com.weiyeli.JianZhiOffer;

/**
 * 二进制中1的个数
 */
public class NumberOf1 {

    /**
     * 思路：把一个整数减去1，将这个数与原来的数做与运算，会将原来那个数的最后一个1变成0
     * 所以最终这个数会变成0，能做几次这样的操作，就说明有几个1
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        
        System.out.println(NumberOf1(-9));
    }
}
