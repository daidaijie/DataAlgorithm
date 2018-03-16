package com.weiyeli.JianZhiOffer.chapter2;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStackToList {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * stack1相当于一个缓冲区，用来保存输入的数据
     * @param code
     */
    public void push(int code) {
        stack1.push(code);
    }

    /**
     * stack2用来负责输出，因为队列是先进先出，所以栈1中栈底的在栈2中是栈顶
     * @return
     */
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }

        /**
         * 当同一个批次的输出完后，在从1中读取数据
         */
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }


    public static void main(String[] args) {
        TwoStackToList list = new TwoStackToList();
        list.push(1);
//        list.push(2);
//        list.push(3);
//        list.push(4);
//        list.push(5);

//        System.out.println(list.pop());
//        System.out.println(list.pop());
//        System.out.println(list.pop());
//        System.out.println(list.pop());
        System.out.println(list.pop());
    }
}
