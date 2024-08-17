package com.leetcode.linkedListTest.test21;
/*
    合并两个升序链表

 */

public class MySolution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(8, null);
        ListNode listNode2 = new ListNode(6, listNode1);
        ListNode listNode3 = new ListNode(5, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        printList(listNode4);
        System.out.println();

        ListNode listNode5 = new ListNode(7, null);
        ListNode listNode6 = new ListNode(5, listNode5);
        ListNode listNode7 = new ListNode(3, listNode6);
        ListNode listNode8 = new ListNode(2, listNode7);
        printList(listNode8);
        System.out.println();

        ListNode listNode = Solution2.mergeTwoLists(listNode4, listNode8);
        printList(listNode);


    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.printf("%d\t", listNode.value);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 首先应当判断两个节点是否为空
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l2 == null ? l1 : l2;
        } else  {
            // 在这里两个节点都有值
            // 我们对l1中的元素进行遍历，取出l1中的元素放入到l2中
            while (l1.next != null) {
                ListNode curr1 = l1;
                l1 = l1.next;
                while (true) {
                    // 将一个元素放到升序链表中
                    ListNode nextNode = l2.next;

                    if (curr1.value <= nextNode.value) {
                        l2.next = curr1;
                        curr1.next = nextNode;
                        break;
                    }
                    l2 = l2.next ;
                    if (nextNode.next == null) {
                        nextNode.next = curr1;
                        break;
                    }
                }
            }
        return l2;
        }
    }

}

class ListNode {
    int value;
    ListNode next;

    ListNode() { }
    ListNode(int value) { this.value = value; }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}