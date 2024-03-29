package com.weiyeli.Algorithm.Sort.test;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {


        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SelectionSort", arr1);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.InsertionSort", arr2);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SelectionSort", arr1);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.InsertionSort", arr2);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SelectionSort", arr1);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.InsertionSort", arr2);

        return;
    }
}
