package com.weiyeli.Leetcode.DP;

/**
 * 45. Jump Game II
 */
public class LeetCode45 {
    public static int jump(int[] nums) {
        //目前为止的jump数
        int times = 0;

        //从nums[0]进行times次jump之后达到的最大范围
        int reached = 0;

        //从0~i这i+1个A元素中能达到的最大范围
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //当reached小于i，说明times次jump不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到记录的max
            //相当于回退几步，因为在覆盖范围内所以肯定可以跳到这个位置
            if (reached < i) {
                times++;
                reached = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return times;
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(jump(a));
    }
}
