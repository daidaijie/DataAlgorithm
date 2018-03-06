package com.weiyeli.JianZhiOffer.chapter4;

/**
 * 复杂链表的复制
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        //插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        // 建立random链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        // 拆分
        // 保留复制后的链表头
        RandomListNode pCloneHead = pHead.next;
        cur = pHead;
        while (cur.next != null) {
            RandomListNode t = cur.next;
            cur.next = t.next;
            cur = t;
        }

        return pCloneHead;
    }
}
