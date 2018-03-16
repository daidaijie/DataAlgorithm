package com.weiyeli.JianZhiOffer.chapter2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：从尾到头打印链表
 */
public class PrintListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        ListNode t = listNode;
        while (t != null) {
            stack.push(t);
            t = t.next;
        }

        while (!stack.isEmpty()) {
            ListNode listNode1 = stack.pop();
            arrayList.add(listNode1.val);
        }

        return arrayList;
    }
}
