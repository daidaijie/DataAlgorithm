package com.weiyeli.DataStructure.linear.stack;

import java.lang.reflect.Array;

/**
 * 数组实现的栈，能存储任意类型的数据
 * @param <T>
 */
public class GeneralArrayStack<T> {

    private static final int DEFAULT_SIZE = 12;
    private T[] mArray;
    private int count;

    public GeneralArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public GeneralArrayStack(Class<T> type, int size) {
        // 不能直接使用mArray = new T[DEFAULT_SIZE];
        mArray = (T[]) Array.newInstance(type, size);
        count = 0;
    }

    //将val添加到栈中
    public void push(T val) {
        mArray[count++] = val;
    }

    //返回"栈顶元素值"
    public T peek() {
        return mArray[count-1];
    }

    //返回"栈顶元素值"，并删除栈顶元素
    public T pop() {
        T ret = mArray[count--];
        return ret;
    }

    //返回栈的大小
    public int size() {
        return count;
    }

    //返回栈是否为空
    public boolean isEmpty() {
        return size()==0;
    }

    // 打印"栈"
    public void PrintArrayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        }

        System.out.println("stack size is " + size());

        int i = size()-1;

        while(i>=0) {
            System.out.println(mArray[i]);
            i--;
        }
    }


    public static void main(String[] args) {
        String tmp;
        GeneralArrayStack<String> astack = new GeneralArrayStack<String>(String.class);

        astack.push("10");
        astack.push("20");
        astack.push("30");

        astack.pop();

        astack.PrintArrayStack();
    }
}
