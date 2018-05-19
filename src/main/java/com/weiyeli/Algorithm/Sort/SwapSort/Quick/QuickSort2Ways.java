package com.weiyeli.Algorithm.Sort.SwapSort.Quick;

import com.weiyeli.Algorithm.Sort.InsertioSort.InsertionSort;

/**
 * 双路快排
 * 功能：解决了大量重复元素的退化问题，把等于v的元素分散到两边
 * BoBo老师版本
 */
public class QuickSort2Ways {

    // 我们的算法类不允许产生任何实例
    private QuickSort2Ways() {
    }

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 如果有大量重复的元素，这样可以让重复的元素均匀分布在两边，使得递归树不会失去平衡
            while (i <= r && arr[i].compareTo(v) < 0)
                i++;

            // 同理
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html
            if (i >= j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);

        return j;
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        //对于小规模数组, 使用插入排序
        if (r - l <= 15) {
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
//        int N = 100000;
//        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 100);
//        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(N, 100);
//        Integer[] arr3 = SortTestHelper.generateRandomArray(N, 0 , 10);
//        Integer[] arr4 = SortTestHelper.generateRandomArray(N, 0 , 10);
//        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.MergeSort", arr4);
//        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.QuickSort2Ways", arr3);
//        int N = 1000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
//        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.Quick.QuickSort2Ways", arr);
//        SortTestHelper.printArray(arr);
        Integer[] a = {5, 4, 3, 2, 1, 0};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
