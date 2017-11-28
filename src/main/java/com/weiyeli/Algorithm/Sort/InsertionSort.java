package com.weiyeli.Algorithm.Sort;

/**
 * 慕课网BoBo老师版本
 */
public class InsertionSort {

    private InsertionSort() {
    }


    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {

        assert l >= 0 && l <= r && r < arr.length;

        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
