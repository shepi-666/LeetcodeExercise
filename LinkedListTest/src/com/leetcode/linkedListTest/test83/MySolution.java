package com.leetcode.linkedListTest.test83;
/*
    删除排序链表中的重复元素(链表为有序链表)

    思路：
    * 核心就是判断当前节点的val是否与下一个节点相同
    * 如果相同的话，就删除下一个节点
    * 迭代(这里是否需要使用双指针？？)
    while (下个节点值 ！= 这个节点值) {
        删除下一个节点;
        p->next;
    }
 */

public class MySolution {
    public static void main(String[] args) {
       ListNode listNode1 = new ListNode(2, null);
       ListNode listNode2 = new ListNode(2, listNode1);
       ListNode listNode3 = new ListNode(2, listNode2);
       ListNode listNode4 = new ListNode(1, listNode3);

       ListNode listNode5 = new ListNode(0,null);
       ListNode listNode6 = null;

       ListNode newNode = deleteDuplicates(listNode6);
       printList(newNode);
    }

    public static void printList(
            ListNode listNode) {
        while (listNode != null) {
            System.out.printf("%d\t", listNode.val
            );
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 如果head为空或者只有一个节点
        if (head == null || head.next == null) return head;

        ListNode p = head;
        // p不是最后一个节点
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next =p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
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