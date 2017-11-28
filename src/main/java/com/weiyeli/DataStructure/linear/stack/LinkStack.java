package com.weiyeli.DataStructure.linear.stack;

/**
 * 链表实现栈
 */
public class LinkStack<T> {

    //定义结点
    private class Node {
        public T data;
        public Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }
    }

    //栈顶元素
    private Node top;

    //元素个数
    private int size;

    //插入数据
    public void push(T element) {
        top = new Node(element, top);
        size++;
    }

    //出栈
    public T pop() {
        Node oldNode = top;
        top = top.next;
        //释放引用
        oldNode.next = null;
        size--;
        return oldNode.data;
    }

    //返回栈顶元素,但不出栈
    public T peek() {
        return top.data;
    }

    //栈的容量
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //打印栈
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (Node current = top; current!=null; current = current.next) {
                System.out.println(current.data);
            }
        }
    }

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int a = stack.pop();

        System.out.println(a);
        stack.printStack();
    }
}
