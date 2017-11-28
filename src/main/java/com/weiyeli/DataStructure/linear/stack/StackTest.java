package com.weiyeli.DataStructure.linear.stack;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> astack = new Stack<Integer>();

        astack.push(10);
        astack.push(11);
        astack.push(12);
        astack.push(13);

        while (!astack.isEmpty()) {
            int tmp = astack.pop();
            System.out.println(tmp);
        }
    }
}
