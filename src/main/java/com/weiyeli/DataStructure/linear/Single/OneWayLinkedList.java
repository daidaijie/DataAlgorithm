package com.weiyeli.DataStructure.linear.Single;

/**
 * 单向链表
 */
public class OneWayLinkedList {

    //头结点
    private Node first;

    //结点数量
    private int size;

    public OneWayLinkedList() {
        size = 0;
        first = new Node(size);
    }

    /**
     * 在尾部增加一个结点
     *
     * @param node
     */
    public void add(Node node) {
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /**
     * 在链表的指定位置前插入结点
     *
     * @param index 插入链表的位置，从1开始
     * @param node  插入的结点
     */
    public void insertNodeByIndex(int index, Node node) {
        if (index < 1 || index > size + 1) {
            System.out.println("插入位置不合法");
            return;
        }

        //记录遍历到第几个结点
        int length = 0;

        Node temp = first;

        while (temp.next != null) {
            if (length == index-1) {
                node.next = temp.next;
                temp.next = node;
                size++;
                return;
            }else {
                temp = temp.next;
                length++;
            }
        }
    }

    /**
     * 在指定位置删除结点
     */
    public void delNodeByIndex(int index) {
        //判断index是否合理
        if (index < 1 || index > size) {
            System.out.println("给定的位置不合理");
            return;
        }

        //步骤跟insertNodeByIndex是一样的，只是操作不一样。
        int length = 0;
        Node temp = first;
        Node q = null;
        while (temp.next != null) {
            if (length == index-1) {
                //删除操作。
                q = temp.next;
                temp.next = q.next;
                q = null;
                size--;
                return;
            }else {
                temp = temp.next;
                length++;
            }

        }
    }


    /**
     * 打印链表
     */
    public void printLinkedList() {
        Node temp = first.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
