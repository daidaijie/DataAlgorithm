package com.weiyeli.JianZhiOffer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 字符串的排列
 * 题目描述：输入一个字符串 , 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc, 则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList Permutation(String str) {
        if (str == null || str.length() == 0)
            return new ArrayList();
        PermutationHelper(str.toCharArray(), 0, ret);
        Collections.sort(ret);

        return ret;

    }

    public void PermutationHelper(char[] cs, int i, ArrayList list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            // 个人理解：每一个字符，首先与自己交换，然后依次与后面的每个字符交换，然后递归操作
            // i=0的for循环，代表了每一种字符开头的情况
            // 而每一个次循环里面的递归，就是对一种情况的遍历
            for (int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                // 回溯法，复位，因为每次只交换一次
                swap(cs, i , j);
            }
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
