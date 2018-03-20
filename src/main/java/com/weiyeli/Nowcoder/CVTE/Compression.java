package com.weiyeli.Nowcoder.CVTE;

import java.util.*;

/**
 * 字符串压缩
 * input： "gghhjyigghgg"
 * output："gghhjyigghgg"
 * input： "gggggaaaabc"
 * output："g5a4bc"
 */
public class Compression {
    public static String Compression(String input) {
        if (input == null || input.length() <= 0)
            return null;
        if (input.length() == 1)
            return input;

        char[] a = input.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int count = 1;
        char ch = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == ch)
                count++;
            else {
                if (count == 1) {
                    stringBuffer.append(String.valueOf(ch));
                    ch = a[i];
                    count = 1;
                } else if (count == 2) {
                    stringBuffer.append(String.valueOf(ch) + String.valueOf(ch));
                    ch = a[i];
                    count = 1;
                } else {
                    stringBuffer.append(String.valueOf(ch) + String.valueOf(count));
                    ch = a[i];
                    count = 1;
                }
            }
        }

        // 最后一个字符串需要单独抽出来
        if (count == 1)
            stringBuffer.append(String.valueOf(ch));
        else if (count == 2)
            stringBuffer.append(String.valueOf(ch) + String.valueOf(ch));
        else stringBuffer.append(String.valueOf(ch) + String.valueOf(count));

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(Compression("gghhjyigghgg"));
        System.out.println(Compression("gggggaaaabc"));
    }
}
