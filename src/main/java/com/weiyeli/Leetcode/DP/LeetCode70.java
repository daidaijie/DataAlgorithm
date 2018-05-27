package com.weiyeli.Leetcode.DP;

/**
 * 70. Climbing Stairs
 */
public class LeetCode70 {
    //LeetCode大佬写的神奇代码，用两个变量就实现了dp操作，使得b永远等于下一个斐波那契数，a等于较大的那个数
    //画一下图很好理解
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }

        return a;
    }
}
