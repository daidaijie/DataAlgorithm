package com.weiyeli.Algorithm.Sort.InsertioSort;

public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * 简单插入排序
     * 空间复杂度：O(1)
     * 平均时间复杂度：O(n^2)
     * 基本有序的情况下时间复杂度为O(n)，只需要比较n-1次
     * 是否稳定：稳定
     * @param arr
     */
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

    /**
     * 折半插入排序
     * 是否稳定：稳定
     */
    public static void halfInsertSort(Comparable[] arr) {
        if (arr == null || arr.length <= 0)
            return;

        int low, high, mid;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            low = 0;
            high = i - 1;
            //high的位置是第一个小于e的位置，插入位置应该是high+1
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid].compareTo(e) > 0)
                    high = mid - 1;
                else low = mid + 1;
            }

            for (int j = i - 1; j >= high + 1; --j)
                arr[j + 1] = arr[j];

            arr[high + 1] = e;
        }
    }

    /**
     * 希尔排序
     * 空间复杂度：O(1)
     * 平均时间复杂度O(n^1.3)
     * 是否稳定：不稳定
     * @param arr
     */
    public static void shellSort(Comparable[] arr) {
        if (arr == null || arr.length <= 0)
            return;
        double d1 = arr.length;
        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;

            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < arr.length; i += d) {
                    int j = i - d;
                    Comparable e = arr[i];
                    for (; j >= 0 && arr[j].compareTo(e) > 0; j -= d) {
                        arr[j+d] = arr[j];
                    }
                    arr[j+d] = e;
                }
            }

            if (d == 1)
                break;
        }
        return;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[j++] = i;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        shellSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
