package com.leetcode.linkedListTest.test21;
/*
    使用递归的方式：
    使用递归的方式来解答此题，代码比较简洁优雅

 */
public class Solution2 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.value < l2.value ) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
