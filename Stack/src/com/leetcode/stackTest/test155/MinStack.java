package com.leetcode.stackTest.test155;
/*
 * 155. 最小栈
 * 设计一个支持push(), pop(), top()操作并且能够在常数时间内检索到最小元素的栈
 * push(x)， 将元素x推入栈中
 * pop() 删除栈顶的元素、
 * top() 返回栈顶的元素
 * getMin() 检索栈中的最小元素
 *
 * 这个是leetcode 中高赞解法，但是里面运用了许多Api，个人认为不如自己写的
 */

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    // 构造方法
    public MinStack() {
        stack = new Stack<>();
    }

    // 入栈方法push
    // 每次入栈两个数，一个是数本身，另一个是当前元素和栈顶元素中最小的元素
    public void push(int val) {
        if (stack.empty()) {
            stack.push(val);
            stack.push(val);
        }
        else if (val < stack.peek()) {
            stack.push(val);
            stack.push(val);
        } else {
            stack.push(val);
            stack.push(stack.peek());
        }
    }

    // 弹栈方法：一次弹出连个元素
    public void pop() {
        stack.pop();
        stack.pop();
    }

    // 获取栈中最小元素的方法
    public int getMin() {
        return stack.peek();
    }

    // 获取栈顶元素的方法
    public int top() {
        // 获取第二个元素
        return stack.get(stack.size() - 2);
    }



}
