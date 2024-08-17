package com.leetcode.linkedListTest.test160;
/*
    方法二：
    先想办法将两个算出两个链表的长度，让其中一个链表先走，最后判断两个指针节点是否相同
    (beats: 100%)
 */

public class Solution2 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int diffLength = getLength(headA) - getLength(headB);
        ListNode pA = headA;
        ListNode pB = headB;
        if (diffLength > 0) {
            pA = movePointer(pA, diffLength);
        } else {
            pB = movePointer(pB, -diffLength);
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;

    }

    /**
     * 移动指针的函数
     * @param p 需要向前移动的指针
     * @param diffLength 需要向前移动的距离
     * @return 返回移动后的节点，如果不返回的话会p指针相当于没有移动
     */
    public static ListNode movePointer(ListNode p, int diffLength) {
        int count = 0;
        while (count != diffLength) {
            p = p.next;
            count++;
        }
        return p;
    }

    // 用来获取链表的长度的函数
    public static int getLength(ListNode head) {
        if (head == null) return 0;
        int count = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        return count;
    }

}
