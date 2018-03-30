package com.weiyeli.Algorithm.Sort.Quick;

// 每天默写一遍快速排序算法
public class QuickSortTest {


    private static void sort(Comparable[] arr, int l, int r) {
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        // 递归函数一定要考虑到递归到底的情况
        if (r <= l)
            return;


        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];


        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }

        swap(arr, l, lt--);
        sort(arr, l, lt);
        sort(arr, gt, r);
    }


    private static void swap(Comparable[] arr, int l, int r) {
        Comparable temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 2, 1, 0};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
