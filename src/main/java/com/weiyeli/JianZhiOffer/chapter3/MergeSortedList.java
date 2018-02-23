package com.weiyeli.JianZhiOffer.chapter3;

import com.weiyeli.JianZhiOffer.LinkedList.ListNode;

/**
 * 合并两个有序的链表
 */
public class MergeSortedList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        // 如果链表1是空链表，则返回链表2，反之同理
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode mergedHead = null;

        if (list1.val < list2.val) {
            mergedHead = list1;
            mergedHead.next = Merge(list1.next, list2);
        } else {
            mergedHead = list2;
            mergedHead.next = Merge(list1, list2.next);
        }

        return mergedHead;
    }
}
