package com.weiyeli.JianZhiOffer.chapter2;

/**
 * 二维数组中的查找
 */
public class FindInArray {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length <= 0)
            return false;

        //首先找到左下角元素的横纵坐标
        int lx = 0;
        int ly = array.length - 1;
        while (lx <= array[0].length-1 && ly >= 0) {
            if (target < array[ly][lx]) {
                ly--;
            }else if (target > array[ly][lx]) {
                lx++;
            }else {
                return true;
            }
        }

        return false;
    }
}
