package com.weiyeli.Algorithm.Sort.Merge;

import com.weiyeli.Algorithm.Sort.Insert.InsertionSort;

import java.util.Arrays;

// 每天默写一遍归并排序
public class MergeSortTest {

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r - 1);
        int i = l;
        int j = mid + 1;

        for (int k = 0; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) > 0) {
                arr[k] = aux[j - l];
                j++;
            } else {
                arr[k] = aux[i - l];
                i++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r <= l)
            return;

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
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
