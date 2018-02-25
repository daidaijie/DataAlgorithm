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

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

//        System.out.println();

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

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
    }

    /**
     * 奇数和奇数的相对顺序不变
     * 偶数和偶数的相对顺序也不变
     * @param array
     */
    public void reOrderArray2(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                int nextOddIdx = i + 1;
                while (nextOddIdx < n && array[nextOddIdx] % 2 == 0) nextOddIdx++;
                if (nextOddIdx == n) break;
                int nextOddVal = array[nextOddIdx];
                for (int j = nextOddIdx; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = nextOddVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 3, 5, 9, 10};
        reOrderArray(a);
    }
}
