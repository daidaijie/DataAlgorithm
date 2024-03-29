package com.weiyeli.Algorithm.Sort.SwapSort.Quick;

import com.weiyeli.Algorithm.Sort.InsertioSort.InsertionSort;
import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

/**
 * 快速排序简单版
 * BoBo老师版本
 */
public class QuickSort {

    // 我们的算法类不允许产生任何实例
    private QuickSort() {
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // 其中j就是分界点，用来划分两个区间
        // arr[l+1..j]<v; arr[j+1..i]>v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr3 = SortTestHelper.generateRandomArray(N, 0 , 10);
        Integer[] arr4 = SortTestHelper.generateRandomArray(N, 0 , 10);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.MergeSort", arr4);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.QuickSort", arr3);
    }
}
