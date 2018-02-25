package com.weiyeli.JianZhiOffer.chapter4;

import java.util.Stack;

/**
 * 包含Min函数的栈
 */
public class MinStack {
    // 数据栈
    private Stack<Integer> stack = new Stack<>();
    // 辅助栈
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < min)
            min = node;
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}