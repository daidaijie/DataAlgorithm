package com.weiyeli.Algorithm.Sort;

public class SortTest {
    public static void main(String[] args) {


        // 测试排序算法辅助函数
        int N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.weiyeli.Algorithm.Sort.SelectionSort", arr);
    }
}
