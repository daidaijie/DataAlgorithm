package com.weiyeli.Leetcode;

/**
 * 88. Merge Sorted Array
 * 题意：将两个排好序的数组合并成一个有序数组
 */
public class Question_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }

        while (j >= 0)
            nums1[k--] = nums2[j--];


    }


    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 6, 9, 0, 0, 0, 0, 0};
        int nums2[] = {5, 11, 15, 18, 20};
        merge(nums1, 5, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
