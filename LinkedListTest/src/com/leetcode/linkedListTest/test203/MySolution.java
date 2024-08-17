package com.leetcode.linkedListTest.test203;

/* 移除链表中值为val的节点，并返回新的头节点 */

import static com.leetcode.linkedListTest.test206.MySolution.reverseList;

public class MySolution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(1, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);





    }

    public static void printListNode(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.printf("%d\t", p.val);
            p = p.next;
        }
    }


    public static ListNode removeElement(ListNode head, int val) {
        ListNode solution = new ListNode(-1);
        solution.next = head;
        ListNode p = solution;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return solution.next;
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
