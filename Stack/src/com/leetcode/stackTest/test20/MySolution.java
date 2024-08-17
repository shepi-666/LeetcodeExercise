package com.leetcode.stackTest.test20;

import java.util.Stack;

/* 20. 有效的括号 */
public class MySolution {
    public static void main(String[] args) {
        System.out.println(Solution.isValid("()()"));
    }

    public static boolean isValid(String s){
        // 先将输入的字符串转换为char数组
        char[] chars = s.toCharArray();
        // 判断char数组的长度，如果为奇数，直接返回false
        if (chars.length % 2 == 1) return false;
        // 将 (length - 1) 的字符存入栈中
        else {
            // 创建一个栈
            Stack<Character> operaStack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
               if (operaStack.empty() || chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
                   operaStack.push(chars[i]);
               else if ((chars[i] == ')' && operaStack.peek() == '(')) operaStack.pop();
               else if ((chars[i] == ']' && operaStack.peek() == '[')) operaStack.pop();
               else if ((chars[i] == '}' && operaStack.peek() == '{')) operaStack.pop();
               else operaStack.push(chars[i]);
            }
            return operaStack.empty();
        }

    }

}
