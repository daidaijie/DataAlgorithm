package com.weiyeli.Algorithm.Sort;


public class SelectionSort {

    //不产生任何实例
    private SelectionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //寻找arr[i]-arr[n-1]区间里面最小值的索引
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                //使用compareTo方法比较两个Compareable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;

            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
