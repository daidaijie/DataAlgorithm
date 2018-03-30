package com.weiyeli.DataStructure.LinkedList;

import com.weiyeli.JianZhiOffer.LinkedList.ListNode;


/**
 * 判断链表是否有环
 */
public class List_ring {
    public boolean isRing(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead.next;

        while (fast != null && fast.next != null) {
            if (slow.val == fast.val)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
