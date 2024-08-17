package com.leetcode.stackTest.test20;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i <chars.length ; i++) {
            if (bracketStack.empty() || chars[i] == '(' || chars[i] == '[' || chars[i] == '{') bracketStack.push(chars[i]);
            else if (chars[i] - bracketStack.peek() == 1 || chars[i] - bracketStack.peek() == 2) bracketStack.pop();
            else bracketStack.push(chars[i]);
        }
        return bracketStack.empty();
    }
}
