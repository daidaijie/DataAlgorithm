package com.weiyeli.Leetcode.DP;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class LeetCode309 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        //s0相当于初始状态，什么也不做，收益初始化为0
        int s0 = 0;
        //s1相当于买了这个状态，初始化的意思是默认第一天就买这支股票
        int s1 = -prices[0];
        //s2相当于买了这个状态，一开始什么都没买，那收益就是0
        int s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int pre0 = s0;
            int pre1 = s1;
            int pre2 = s2;

            //从第二天开始迭代，s0这个状态的最大值要么就是继承前一个就是继续什么都不做，要么就是前一个卖了的状态
            s0 = Math.max(pre0, pre2);

            //从第二天开始迭代，s1这个状态的最大值是Max(dp[i-2], dp[i-1])
            //相当于判断是第i-1天买我的钱多，还是第i-2天买我的钱多
            s1 = Math.max(pre1, pre0 - prices[i]);

            //从第二天开始迭代，s2这个状态的最大值要么是继承前一个s2相当于我卖了之后就不买了，
            // 要么就是上一个买了的状态的钱+卖了这支股票的钱，相当于第i天卖了
            s2 = Math.max(pre2, pre1 + prices[i]);
        }

        //因为s1状态不完整，不可能是结果，即不可能买了不卖是最大的
        return Math.max(s0, s2);
    }

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,3,2,1,0,1000};
        System.out.println(maxProfit(a));
    }
}
