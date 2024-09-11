package com.leetcode.arrayTest.tencent;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-09-05 19:25
 * @description:
 */
public class T2CommonPart {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode mergeList (ListNode a, ListNode b) {
        // write code here
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode former = a;

        // 首先找到链表的前半部分
        while (p1 != null && p2 != null && p1.val == p2.val) {
            former = p1;
            p1 = p1.next;
            p2 = p2.next;

        }

        // 找链表的后半部分，两个链表的公共节点
        ListNode q1 = p1;
        ListNode q2 = p2;
        while (q1 != q2) {
            if (q1.next != null) {
                q1 = q1.next;
            } else {
                q1 = p2;
            }

            if (q2.next != null) {
                q2 = q2.next;
            } else {
                q2 = p1;
            }
        }
        // 找到公共的节点
        former.next = q1;

        return a;

    }


    @Test
    public void test() {
        ListNode num1 = new ListNode(1);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        ListNode num4 = new ListNode(4);
        ListNode num5 = new ListNode(5);
        ListNode num6 = new ListNode(1);
        ListNode num7 = new ListNode(2);

        num4.next = num5;

        num1.next = num2;
        num2.next = num3;
        num3.next = num4;

        num6.next = num7;
        num7.next = num4;

        ListNode a = num1;
        ListNode b = num6;

        System.out.println(mergeList(a, b));

    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
