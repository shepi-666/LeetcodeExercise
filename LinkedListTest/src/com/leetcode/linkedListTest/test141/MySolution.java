package com.leetcode.linkedListTest.test141;
/*
    判断一个链表是否有环

    其实这道题我是没有思路的，看到人家的解析，可以使用快慢双指针
 */

public class MySolution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, null);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);

        listNode1.next = listNode2;

        System.out.println(hasCycle(listNode4));

    }

    public static boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (true) {
            // 如果快指针达到链表末尾，返回false
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            // 快指针跳两个节点，慢指针一个节点,
            // 两者的速度只差了一个节点，这样肯定会相遇的
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            // 两个指针相遇说明链表中有环
            if (fastPointer == slowPointer) return true;
        }

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