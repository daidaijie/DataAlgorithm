package com.weiyeli.JianZhiOffer.chapter2;

/**
 * 变态跳台阶
 */
public class JumpFloorII {


    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            // 因为每一次计算都需要前一次，所以递归没有重复计算，编写比较简洁
            return 2 * JumpFloorII(target - 1);
        }
    }
}
