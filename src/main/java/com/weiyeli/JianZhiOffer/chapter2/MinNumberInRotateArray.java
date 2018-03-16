package com.weiyeli.JianZhiOffer.chapter2;


/**
 * 旋转数组的最小数字
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0)
            throw new RuntimeException("参数错误");

        if (array.length == 1)
            return array[0];

        int left = 0;
        int right = array.length - 1;
        int mid = left;

        //如果第一个元素小于最后一个元素，说明没有旋转，则直接返回第一个元素
        while (array[left] >= array[right]) {

            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = left + (right - left) / 2;

            //如果array[left]、array[right]、array[mid]三个相等,则只能顺序查找
            if (array[left] == array[right] && array[mid] == array[left])
                return MinInOrder(array);

            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }

        return array[mid];
    }

    public static int MinInOrder(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] < array[i])
                return array[i + 1];
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(a));
        int[] b = {1, 1, 1, 0, 1};
        System.out.println(minNumberInRotateArray(b));
        int[] c = {1};
        System.out.println(minNumberInRotateArray(c));
    }


}
