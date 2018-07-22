package com.weiyeli.JianZhiOffer.chapter8;

import java.util.LinkedList;

/**
 * 孩子们的游戏
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.get(0);
    }
}
