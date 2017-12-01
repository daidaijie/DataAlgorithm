package com.weiyeli.Interview.Using_Array;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int n = nums.length;
        int count = 0;
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }else {
                count++;
            }
        }

        while (j < n)
            nums[j++] = 0;

        return n-count;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        removeElement(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }
}
