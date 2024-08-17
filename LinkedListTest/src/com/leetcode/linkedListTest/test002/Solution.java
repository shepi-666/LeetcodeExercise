package com.leetcode.linkedListTest.test002;

public class Solution {
    public ListNode addTwoSumNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int[] retval = new int[2];
        ListNode header = new ListNode();
        ListNode p = header;
        while (l1 != null && l2 != null) {
            sum(l1, l2, retval);
            p.next = new ListNode(retval[0]);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                sum(l2, new ListNode(0), retval);
                p.next = new ListNode(retval[0]);
                p = p.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                sum(l1, new ListNode(0), retval);
                p.next = new ListNode(retval[0]);
                p = p.next;
                l1 = l1.next;
            }
        }
        if (retval[1] == 1) {
            p.next = new ListNode(1);
        }
        return header.next;
    }

    public static void sum(ListNode l1, ListNode l2, int[] result) {
        int sum = (l1.val + l2.val + result[1]) % 10;
        int c = (l1.val + l2.val + result[1]) / 10;
        result[0] = sum;
        result[1] = c;
    }
}

