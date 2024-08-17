package com.leetcode.linkedListTest.test21;
// 思路一：
// 使用迭代的方式
/*
    1. 先建立一个解的头节点，并建立一个指针节点指向头节点
    2. 拿l1和l2两个节点作比较，哪一个更小,那么指针节点的next就指向哪一个
    3. 对指针节点，以及指针next所指向的节点进行更新
        l = l.next;
        l1 = l1.next; (l2 = l2.next;)
    4. 迭代的结束条件是其中一个指针为空
        将指针指向非空的那一个节点即可
    5. 返回solution.next

    需要注意的是：不要一开始就对l1和l2的状态进行讨论
 */

public class Solution1 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0, null);
        ListNode solution = listNode;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            listNode.next = l2;
        }
        if (l2 == null) {
            listNode.next = l1;
        }
        return solution.next;

    }
}
