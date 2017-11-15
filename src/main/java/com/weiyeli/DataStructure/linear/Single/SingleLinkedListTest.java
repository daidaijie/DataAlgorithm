package com.weiyeli.DataStructure.linear.Single;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        OneWayLinkedList list = new OneWayLinkedList();
        for (int i = 1; i <= 10; i++) {
            Node node = new Node(i);
            list.add(node);
        }
        list.printLinkedList();

        Node node = new Node(88);
        list.insertNodeByIndex(1, node);

        list.printLinkedList();

        list.delNodeByIndex(1);
        list.printLinkedList();
    }
}
