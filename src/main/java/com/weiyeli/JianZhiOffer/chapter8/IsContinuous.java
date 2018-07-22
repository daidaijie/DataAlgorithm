package com.weiyeli.JianZhiOffer.chapter8;

import java.util.Arrays;

/**
 * 扑克牌顺子
 */
public class IsContinuous {
    public static boolean isContinuous(int[] nums) {
        if (nums.length < 5)
            return false;
        Arrays.sort(nums);
        int cnt = 0;
        for (int num : nums)                   /* 统计癞子数量 */
            if (num == 0)
                cnt++;

        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;  /* 使用癞子去补全不连续的顺子 */
        }
        return cnt >= 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 3, 6, 7, 0, 0};
        System.out.println(isContinuous(a));
    }
}
