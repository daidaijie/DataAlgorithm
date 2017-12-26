package com.weiyeli.DataStructure.tree.Binary_Search_tree.Binary_search;

/**
 * 非递归的二分查找算法
 */
public class BinarySearch {
    // 我们的算法类不允许产生任何实例
    private BinarySearch() {
    }

    /**
     * 二分查找法，在有序数组中arr中，查找target
     * 如果找到target，返回响应的索引index，如果没找到返回-1
     */
    public static int find(Comparable[] arr, Comparable target) {
        // 在arr[l...r]中查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) == 0)
                return mid;

            if (arr[mid].compareTo(target) > 0)
                r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 15, 20, 45, 120};
        System.out.println(find(a, 120));
    }
}
