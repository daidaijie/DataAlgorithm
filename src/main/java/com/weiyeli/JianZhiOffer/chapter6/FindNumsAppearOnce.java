package com.weiyeli.JianZhiOffer.chapter6;

/**
 * 数组中只出现一次的数字
 * 题目大意：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * 题解：两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
 * diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }
        diff &= -diff;
        for (int num : array) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else num2[0] ^= num;
        }
    }
}
