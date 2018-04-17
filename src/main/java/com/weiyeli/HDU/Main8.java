package com.weiyeli.HDU;

import java.util.Scanner;

public class Main8 {

    static Integer res;

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Integer[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Integer v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 如果有大量重复的元素，这样可以让重复的元素均匀分布在两边，使得递归树不会失去平衡
            while (i <= r && arr[i]<v)
                i++;

            // 同理
            while (j >= l + 1 && arr[j]>v)
                j--;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html
            if (i >= j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);

        return j;
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Integer[] arr, int l, int r) {
        int p = partition(arr, l, r);
        res += Integer.valueOf(arr[p]) * (arr.length-p-1);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Integer[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,31)-1);

    }
}
