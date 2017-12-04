package com.weiyeli.JianZhiOffer;

/**
 * 跳台阶
 */
public class JumpFloor {

    public int JumpFloor(int target) {

        if (target < 3)
            return target;

        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
