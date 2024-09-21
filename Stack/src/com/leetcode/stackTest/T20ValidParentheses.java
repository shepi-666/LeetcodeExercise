package com.leetcode.stackTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 15:17
 * @description: 有效的括号
 */
public class T20ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 注意括号顺序，当前字符要比栈中的大
            if (stack.size() != 0 && c - stack.peek() <= 2 && c - stack.peek() > 0) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }


    @Test
    public void testSolution() {
        String s = "([])";
        System.out.println(isValid(s));
    }

}
