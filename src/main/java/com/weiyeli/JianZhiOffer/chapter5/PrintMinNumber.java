package com.weiyeli.JianZhiOffer.chapter5;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 把数组排成最小的数
 */
public class PrintMinNumber {
    public static String PrintMinNumber(int[] numbers) {
        String[] a = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            a[i] = String.valueOf(numbers[i]);
        }
        // 解题关键，比较s1和s2不是直接比较，而是应该比较s1+s2和s2+s1
        Arrays.sort(a, (s1,s2) -> (s1+s2).compareTo(s2+s1));
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : a) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }
}
