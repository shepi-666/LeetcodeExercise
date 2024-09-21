package com.leetcode.stackTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 16:16
 * @description:
 */
public class T155MinStack {

    @Test
    public void testSolution() {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());








    }


}
class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minNumsStack;
    private int minValue = Integer.MAX_VALUE;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minNumsStack = new Stack<>();
    }

    public void push(int val) {
        minValue = Math.min(minValue, val);
        minNumsStack.push(minValue);
        dataStack.push(val);
    }

    public void pop() {
        dataStack.pop();
        minNumsStack.pop();
        minValue = minNumsStack.size() == 0 ? Integer.MAX_VALUE : minNumsStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minNumsStack.peek();
    }
}

class MinStackI {

    class ListNode {
        int val;
        int min;
        ListNode pre;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode() {}
    }

    private ListNode head;
    private ListNode tail;

    public MinStackI() {
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.pre = head;
        head.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        ListNode cur = new ListNode(val);
        ListNode pre = tail.pre;
        cur.min = Math.min(val, pre.min);

        // 尾插法
        pre.next = cur;
        cur.pre = pre;

        cur.next = tail;
        tail.pre = cur;
    }

    public void pop() {
        ListNode cur = tail.pre;
        tail.pre = cur.pre;
        cur.pre.next = tail;
    }

    public int top() {
        return tail.pre.val;
    }

    public int getMin() {
        return tail.pre.min;
    }
}
