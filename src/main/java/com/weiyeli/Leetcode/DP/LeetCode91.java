package com.weiyeli.Leetcode.DP;

/**
 * 91. Decode Ways
 */
public class LeetCode91 {
    public static int numDecodings(String s) {
        int length = s.length();

        if (length <= 0 || s.charAt(0) == '0')
            return 0;

        //dp[i]表示前i个数字所组成的最小的可能总和
        int[] dp = new int[length + 1];

        if (s.charAt(0) == '2' || s.charAt(0) == '1')
            dp[0] = 1;
        else dp[0] = 0;

        dp[1] = 1;

        // 1 <= i < length，遍历字符串
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                //如果 s[i-1] == 1 or s[i-1] = 2，说明可以与0结合，那我们只要继承dp[i-2]
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i+1] = dp[i - 1];
                } else {
                    //如果不能与前面结合，直接赋值为0
                    dp[i+1] = 0;
                    continue;
                }
            } else {
                //如果可以与前一个结合,那个s[i-1]和s[i]这两个字符组成的数字应该在[10,26]这个区间内
                //这样写比用Inter.valueOf(s.subString())更快
                if ((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                    dp[i+1] = dp[i] + dp[i - 1];
                } else {
                    //不能就只能继承前面一个
                    dp[i+1] = dp[i];
                }
            }
        }

        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
//        String s = "abcd";
//        System.out.println(s.charAt(0));
    }
}
