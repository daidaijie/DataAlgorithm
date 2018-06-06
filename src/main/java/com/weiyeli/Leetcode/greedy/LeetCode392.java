package com.weiyeli.Leetcode.greedy;

/**
 * 392. Is Subsequence
 */
public class LeetCode392 {

    //我天朝大佬的解法
    public boolean isSubsequence2(String s, String t) {
        for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
            //使用java的类函数，java类函数肯定在jvm上会有优化所以比手写代码更快
            //首先toCharArray就要性能开销
            pos = t.indexOf(s.charAt(i), pos);
            if (pos == -1) return false;
        }
        return true;
    }

    public static boolean isSubsequence(String s, String t) {

        if (s == null || t == null)
            return false;

        //空串是所有串的子串
        if (s.length() == 0)
            return true;

        //如果t是空串且s不是空串，那么直接返回错
        if (t.length() == 0 && s.length() != 0)
            return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (a[j] == b[i] && j == a.length - 1)
                return true;
            else if (a[j] == b[i]) {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "abcdef";
        System.out.println(a.indexOf("f"));
    }
}
