package com.weiyeli.JianZhiOffer.chapter5;

/**
 * 丑数
 */
public class GetUglyNumber_Solution {
    private static boolean IsUgly(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return (number == 1) ? true : false;
    }

    // 脑残暴力方法
    public static int GetUglyNumber_Solution2(int index) {
        if (index <= 0)
            return 0;

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            number++;
            if (IsUgly(number)) {
                uglyFound++;
            }
        }

        return number;
    }

//    public static int GetUglyNumber_Solution(int index) {
//        if (index <= 6)
//            return index;
//
//    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution2(1500));
    }
}
