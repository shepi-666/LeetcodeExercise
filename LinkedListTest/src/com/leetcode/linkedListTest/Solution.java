package com.leetcode.linkedListTest;



/**
 * @author: DongShaowei
 * @create: 2024-09-02 14:30
 * @description:
 */
public class Solution {

    public ListNode reverseLinkedList(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode p = head;
        ListNode pre = h;


        // 遍历到最后一个节点
        while (p.next != null) {
            ListNode next = p.next;
            p.next = pre; // 当前节点的下一个节点指向前驱节点
            pre.next = p;
            p = p.next;

        }

        return h.next;
    }

}



/**
 * 链表节点
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
