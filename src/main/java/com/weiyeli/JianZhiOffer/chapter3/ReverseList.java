package com.weiyeli.JianZhiOffer.chapter3;

import com.weiyeli.JianZhiOffer.LinkedList.ListNode;

/**
 * 反转链表
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;

        while (node != null) {
            ListNode next = node.next;

            if (next == null)
                reverseHead = node;

            node.next = pre;

            pre = node;
            node = next;
        }

        return reverseHead;
    }
}
