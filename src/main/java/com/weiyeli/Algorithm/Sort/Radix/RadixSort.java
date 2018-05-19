package com.weiyeli.Algorithm.Sort.Radix;

public class RadixSort {


    private int maxLength(Comparable[] arr) {
        int maxLength = 0;
        int arrayLength = arr.length;
        for (int i = 0; i < arrayLength; i++) {
            int currentLength = length(arr[i]);
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    private int length(Comparable number) {
        return String.valueOf(number).length();
    }

    /**
     * 获取x这个数的d位数上的数字
     * 比如获取 123 的 0 位数，返回3
     * @param x
     * @param d
     * @return
     */
    private int getDigit(int x, int d) {
        int a = 1;
        for (int i = 1; i < d; i++)
            a *= 10;
        return (x / a) % 10;
    }


    public static void main(String[] args) {

    }
}
