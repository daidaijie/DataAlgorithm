package com.weiyeli.Algorithm.Sort.HeapSort;

/**
 * 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
 */
public class HeapSort {

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftDown(Comparable[] arr, int n, int k) {

        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            //j等于左儿子
            int j = 2 * k + 1;
            //如果左儿子不满足，就换右儿子
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;

            if (e.compareTo(arr[j]) >= 0)
                break;

            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        HeapSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
