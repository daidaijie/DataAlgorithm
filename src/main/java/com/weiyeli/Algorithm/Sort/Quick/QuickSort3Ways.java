package com.weiyeli.Algorithm.Sort.Quick;

import com.weiyeli.Algorithm.Sort.Insert.InsertionSort;
import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

public class QuickSort3Ways {

    // 我们的算法类不允许产生任何实例
    private QuickSort3Ways() {
    }

    // 递归使用快速排序，对arr[l..r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组，使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围内，选择一个数值作为标定点pivot
        // (int)2.99 = 2
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int lt = l;         //arr[l+1...lt] < v
        int gt = r + 1;     //arr[gt...r] > v
        int i = l + 1;      //arr[lt+1...i] == v

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }


    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100);
        Integer[] arr2 = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.Quick.QuickSort2Ways", arr1);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.Quick.QuickSort3Ways", arr2);
    }
}
