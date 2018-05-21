package com.weiyeli.Algorithm.Sort.Merge;

import com.weiyeli.Algorithm.Sort.InsertioSort.InsertionSort;
import com.weiyeli.Algorithm.Sort.test.SortTestHelper;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 是否稳定：稳定
 */
public class MergeSortBU {
    // 我们的算法类不允许产生任何实例
    private MergeSortBU() {
    }

    private static Comparable[] aux = null;

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
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

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
//        for (int sz = 1; sz < n; sz *= 2)
//            for (int i = 0; i + sz < n; i += 2*sz)
//                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));

//        // Merge Sort Bottom Up 优化
//        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < n; i += 16)
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));

        for (int sz = 16; sz < n; sz += sz)
            // i+sz<n的意思是第二部分存在，如果不存在就不必要merge了
            for (int i = 0; i + sz < n; i += 2 * sz)
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));

    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.MergeSortBU", arr1);

//        Integer []a = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
//        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.MergeSortBU", a);
//        SortTestHelper.printArray(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+" ");
//        }
    }
}