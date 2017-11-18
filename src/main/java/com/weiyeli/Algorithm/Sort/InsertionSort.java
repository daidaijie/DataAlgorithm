package com.weiyeli.Algorithm.Sort;

/**
 * 慕课网BoBo老师版本
 */
public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //寻找元素arr[i]的合适的插入位置
        for (int i = 1; i < n; i++) {
            for (int j = i; j>0 && arr[j].compareTo(arr[j-1]) < 0; j--)
                swap(arr, j, j-1);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.InsertionSort", arr);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SelectionSort", arr);


        return;
    }
}
