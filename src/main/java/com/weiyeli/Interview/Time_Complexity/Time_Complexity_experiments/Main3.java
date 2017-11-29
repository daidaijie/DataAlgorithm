package com.weiyeli.Interview.Time_Complexity.Time_Complexity_experiments;

public class Main3 {

    public static void main(String[] args) {

        // 数据规模倍乘测试binarySearch
        // O(logn)
        // O(logn)级别的算法扩大一倍，时间复杂度上升1+log2/logN倍，而且N越大，上升越慢
        System.out.println("Test for Binary Search:");
        for(int i = 10 ; i <= 28 ; i ++){

            int n = (int)Math.pow(2, i);
            Integer[] arr = MyUtil.generateOrderedArray(n);

            long startTime = System.currentTimeMillis();
            MyAlgorithmTester.binarySearch(arr, n, 0);
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + " ms");
        }
    }
}
