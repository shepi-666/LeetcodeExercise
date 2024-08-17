package com.leetcode.linkedListTest.test206;

public class MySolution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4, null);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);

        printListNode(reverseList(listNode4));
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode headB = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode nextNode = p.next;
            p.next = headB.next;
            headB.next = p;
            p = nextNode;
        }
        return headB.next;
    }

    public static void printListNode(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.printf("%d\t", p.val);
            p = p.next;
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