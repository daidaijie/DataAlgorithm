package com.weiyeli.JianZhiOffer.chapter4;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class IsPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushA[i]);
            while (j < n && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
