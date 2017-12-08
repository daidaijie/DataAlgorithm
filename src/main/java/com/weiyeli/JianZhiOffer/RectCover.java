package com.weiyeli.JianZhiOffer;

/**
 * 矩形覆盖
 */
public class RectCover {

    public int RectCover(int target) {
        if (target < 1)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        for (int i = 3; i <=  target; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
