package com.weiyeli.Leetcode.greedy;

import java.util.Arrays;

public class LeetCode455 {
    //保证每一次分配刚好满足要求就好
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        int j = 0;
        while( i < g.length && j < s.length){
            if( g[i]<=s[j] ){
                i++;
                j++;
                res++;
            } else{
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
