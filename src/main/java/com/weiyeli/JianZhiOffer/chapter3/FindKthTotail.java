package com.weiyeli.JianZhiOffer.chapter3;

import com.weiyeli.JianZhiOffer.LinkedList.ListNode;


/**
 * 链表中倒数第K个结点
 */
public class FindKthTotail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return null;

        ListNode pAhead = head;
        ListNode pBehind = null;

        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else {
                // 如果结点数不足K个
                return null;
            }
        }

        pBehind = head;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }
}
