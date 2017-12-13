package com.weiyeli.Interview.Using_Array;

public class SortColors {

    //采用计数排序
    public static void sortColors(int[] nums) {

        if (nums == null || nums.length <= 0)
            return;

        int red = 0;
        int white = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                red++;
            else if (nums[i] == 1)
                white++;
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i = red; i < white + red; i++) {
            nums[i] = 1;
        }

        for (int i = white + red; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    //只扫描一遍，类似于三路快速排序
    //nums[0..zero] nums[second,n]==2
    public static void sortColors2(int[] nums) {
        int second = nums.length;
        int zero = -1;
        for (int i = 0; i < second; i++) {
            while (nums[i] == 2 && i < second) swap(nums, i, --second);
            while (nums[i] == 0 && i > zero) swap(nums, i, ++zero);
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    public static void main(String[] args) {
        int nums[] = {1, 0};
        sortColors2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
