package com.weiyeli.JianZhiOffer.chapter5;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0)
            return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result)
                times++;
            else times--;
        }

        // 检查得到的result是否超过数组长度的一半
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) times++;
        }

        return times > array.length / 2 ? result : 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 2, 4, 2, 2, 6};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
