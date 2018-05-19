package com.weiyeli.DataStructure.Heap;

import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

/**
 * 原地堆排序
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 是否稳定：不稳定
 */
public class HeapSort {
    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 由于堆是从0开始索引的，故应用Heapify建堆，最后一个非叶子结点是的索引是(最后一个元素的索引-1)/2
        // 最后一个元素的索引 = n -1
        // 初始化堆，时间复杂度为O(n)
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // ShiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {

        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j++;

            if (arr[k].compareTo(arr[j]) > 0)
                break;

            arr[k] = arr[j];

            k = j;
        }

        arr[k] = e;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.weiyeli.DataStructure.Heap.HeapSort", arr);

        return;
    }
}
