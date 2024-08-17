package com.leetcode.linkedListTest.test160;

/*
    判断两个链表是否相交，如果相交，返回相交的节点，如果不相交的话返回null
    方法一：(beats: 28%)
    两个指针分别指向headA和headB，遍历完以后pA指向headB, pB指向headA
    如果两个链表没有相交的地方，指针会再次指向两个链表的末尾
    但是如果两个链表有相交的地方，指针就会相等
 */
public class MySolution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5, null);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(8, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);

        ListNode listNode5 = new ListNode(4,  listNode4);
       ListNode listNode6 = new ListNode(1, listNode3);
        ListNode listNode7 = new ListNode(6, listNode6);
        ListNode listNode8 = new ListNode(5, listNode7);
        System.out.println(Solution2.getIntersectionNode(listNode4, listNode8));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果链表为空返回null
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 注意：pA和pB在遍历完两个链表的时，程序跳出循环有两个可能
        // 1. pA == pB != null;
        // 2. pA == pB == null;
        while (pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA ;
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode() { }
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}