package com.weiyeli.Leetcode.DoublePoint;

public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum  == c) {
                return true;
            }else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
