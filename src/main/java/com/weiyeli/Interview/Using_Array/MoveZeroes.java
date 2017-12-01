package com.weiyeli.Interview.Using_Array;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        /**
         * 自己想的神奇方法
         */
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                for (int j = i+1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                        break;
//                    }
//                }
//            }
//        }

        /**
         * 方法二：把非零的元素移到前面，然后后面的元素补零
         */
//        int insertPos = 0;
//        for (int num: nums) {
//            if (num != 0) nums[insertPos++] = num;
//        }
//
//        while (insertPos < nums.length)
//            nums[insertPos++] = 0;

        /**
         * 方法三：把零元素和非零元素交换位置
         */
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }else j++;  //如果全部都是非零元素，则不需要交换
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
