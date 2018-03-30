package com.weiyeli.DataStructure.tree.Binary_Search_tree.Binary_search;

// 每天默写一遍二分搜索
public class BinarySearchTest {

    public static int find(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) == 0)
                return mid;
            else if (arr[mid].compareTo(target) > 0)
                r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = {100,15,78,63,52,95,1};
        System.out.println(find(a,Integer.valueOf(52)));
    }
}
