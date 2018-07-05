package com.weiyeli.JianZhiOffer.chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class RecorderOddEven {
    /**
     * 时间复杂度: O(n)，空间复杂度: O(1)
     */
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return;
        int pBegin = 0;
        int pEnd = array.length - 1;

        while (pBegin < pEnd) {
            // 向后移动pBegin，直到它指向偶数
            while (pBegin < pEnd && (array[pBegin] & 0x1) == 1)
                pBegin++;

            // 向前移动pEnd，直到它指向奇数
            while (pBegin < pEnd && (array[pEnd] & 0x1) == 0)
                pEnd--;

            if (pBegin < pEnd) {
                int temp = array[pBegin];
                array[pBegin] = array[pEnd];
                array[pEnd] = temp;
            }
        }
    }

    /**
     * 奇数和奇数的相对顺序不变
     * 偶数和偶数的相对顺序也不变
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     */
    public void reOrderArray2(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums)
            if (val % 2 == 1)
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 3, 5, 9, 10};
        reOrderArray(a);
    }
}
