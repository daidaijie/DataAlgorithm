package com.weiyeli.Algorithm.Sort.Merge;

import com.weiyeli.Algorithm.Sort.InsertioSort.InsertionSort;
import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 * BoBo老师版本
 */
public class MergeSort {

    private MergeSort() {
    }

    //将arr[l..mid]和arr[mid+1..r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //辅助数组
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引i；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    //递归使用归并排序，对arr[l..r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        //递归到底的情况一定要写清楚
        if (l >= r)
            return;

        // 优化2: 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.MergeSort", arr);
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 10);
        SortTestHelper.printArray(arr1);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.Merge.MergeSort", arr1);
    }
}
