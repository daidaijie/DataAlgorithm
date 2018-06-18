package com.weiyeli.JianZhiOffer.chapter5;

import java.lang.management.ManagementFactory;

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

    final static int d[] = {2, 3, 5};

    /**
     * 这个题其实就是一个DP问题
     * 通过3个指针记录乘到第几个数
     * 每一次更新num数组，num数组中存的总是2、3、5三种情况的最小值
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;

        int[] a = new int[index];
        a[0] = 1;

        // p[0]存的是最小用于乘2比较数在数组a中的位置
        // p[1]存的是最小用于乘3比较数在数组a中的位置
        // p[2]存的是最小用于乘5比较数在数组a中的位置
        int[] p = new int[]{0, 0, 0};

        //同理，num[i]存的就是具体的这个数
        int[] num = new int[]{2, 3, 5};
        int cur = 1;

        while (cur < index) {
            int m = finMin(num[0], num[1], num[2]);
            if (a[cur - 1] < num[m])
                a[cur++] = num[m];
            p[m] += 1;
            num[m] = a[p[m]] * d[m];
        }

        return a[index - 1];
    }

    private static int finMin(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 0 : min == num3 ? 1 : 2;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1500));
    }
}
