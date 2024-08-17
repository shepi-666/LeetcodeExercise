package com.leetcode.linkedListTest.test002;

import java.util.Map;

/*
* 两数之和：
* 思路：通过遍历链表的方式将链表中的数据转换为字符串，然后使用字符串的方式将两个数相加\
* 问题：将数字存储在链表中的方法
* 主要问题就是链表的长度可能过长
* */
public class MySolution {
    public ListNode addTwoSumNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        if (l1.val == 0) {
            return l2;
        } else if (l2.val == 0) {
            return l1;
        } else {
            long num1 = listNode2Int(l1);
            long num2 = listNode2Int(l2);
            long sum = num1 + num2;
            int n = (sum + "").length();
            return int2ListNode(sum, n);
        }
    }

    // 将一个字符串使用链表的方式存储
    public ListNode int2ListNode(long num, int n) {
        ListNode[] nodes = new ListNode[n];
        for (int i = n - 1; i > 0 ; i--) {
            int m = (int)(num / (long) Math.pow(10, i));
            nodes[i] = new ListNode(m);
            num = num - m * (long) Math.pow(10, i);
        }
        nodes[0] = new ListNode((int)num);
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }
    // 将链表中的数字取出来
    public long listNode2Int(ListNode listNode) {
        long num = 0;
        int n = 0;
        ListNode p = listNode;
        while (p != null) {
            num = p.val * (long)Math.pow(10, n) + num;
            n++;
            p = p.next;
        }
        return num;
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