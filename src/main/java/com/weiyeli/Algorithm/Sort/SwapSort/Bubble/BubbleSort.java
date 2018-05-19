package com.weiyeli.Algorithm.Sort.SwapSort.Bubble;

import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private BubbleSort() {
    }

    /**
     * 冒泡排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 是否稳定：稳定
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length <= 0)
            return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    Comparable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }

        return;
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] a = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.printArray(a);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SwapSort.BubbleSort.BubbleSort", a);
        SortTestHelper.printArray(a);
    }
}
