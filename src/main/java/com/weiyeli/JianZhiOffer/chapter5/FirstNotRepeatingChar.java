package com.weiyeli.JianZhiOffer.chapter5;

/**
 * 第一个只出现一次的字符位置
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0)
            return -1;

        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1) return i;

        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        a['c'] = 3;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
