package com.leetcode.stackTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 20:49
 * @description: 实现计算器
 */
public class T224Calculator {

    public int calculate(String s) {

        // 将数组转换为逆波兰表达式
        String RPN = transform(s);

        // 将逆波兰表达式转换为计算结果
        return evalRPN(RPN);
    }

    private int evalRPN(String s) {
        // 特殊情况判断
        String[] rpn = s.split(" ");

        // 最多有 n / 2 + 1个操作数
        int[] dataStack = new int[rpn.length / 2 + 1];
        int index = 0; // 模拟栈帧
        for (String token : rpn) {
            switch (token) {
                case "+": {
                    // 加法，取两位操作数相加，计算结果赋值到第一个操作数中
                    dataStack[index - 2] += dataStack[--index]; // 指针左移一位，准备覆盖第二个操作数
                    break;
                }
                case "-": {
                    dataStack[index - 2] -= dataStack[--index];
                    break;
                }
                case "*": {
                    dataStack[index - 2] *= dataStack[--index];
                    break;
                }
                case "/": {
                    dataStack[index - 2] /= dataStack[--index];
                    break;
                }
                default: {
                    // 操作数，直接入栈
                    dataStack[index++] = Integer.parseInt(token);
                }
            }
        }
        return dataStack[0];
    }

    /**
     * 将前缀表达式转换为后缀表达式
     * @param s
     * @return
     */
    private String transform(String str) {
        // 去除恶心的空格
        String s = str.replace(" ", "");
        StringBuilder res = new StringBuilder(); // 存储后缀表达式
        Stack<Character> opera = new Stack<>(); // 存储运算符

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);


            // 如果当前是操作数，直接添加到结果中
            if (Character.isDigit(cur)) {
                // 处理多位数
                while (i < s.length() && (Character.isDigit(s.charAt(i)))) {
                    res.append(s.charAt(i++));
                }
                res.append(' '); // 使用空格分隔
                i--; // 回退
            }
            // 当前是左括号
            else if (cur == '(') {
                // 直接入符号栈
                opera.push(cur);
            }
            // 如果当前是右括号，弹出栈顶直到遇到左括号
            else if (cur == ')') {
                while (!opera.isEmpty() && opera.peek() != '(') {
                    res.append(opera.pop()).append(" ");
                }
                // 弹出左括号
                if (!opera.isEmpty() && opera.peek() == '(') {
                    opera.pop();
                }
            }

            // 当前是运算符
            else if (isOperator(cur)) {
                // 处理负号，如果负号是第一个字符或者前面的非空字符是括号
                if (cur == '-' ) {
                    if (i == 0 || s.charAt(i - 1) == '(') {
                        res.append(0).append(" ");
                    }
                }

                // 当前运算符优先级小于等于栈顶
                while (!opera.isEmpty() && getPriority(cur) <= getPriority(opera.peek())) {
                    res.append(opera.pop()).append(" ");
                }
                // 将当前压入栈中
                opera.push(cur);
            }
        }

        // 弹出栈中剩余的运算符
        while (!opera.isEmpty()) {
            res.append(opera.pop()).append(' ');
        }
        return res.toString();
    }


    /**
     * 判断是否为运算符
     * @param c
     * @return
     */
    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int getPriority(char expressChar) {
        
        if (expressChar == '*' || expressChar == '/') {
            return 1;
        } else if (expressChar == '+' || expressChar == '-'){
            return 0;
        } else {
            return -1;
        }
    }
    @Test
    public void testSolution() {
        String s = "1-(     -2)";
        System.out.println(transform(s));
    }
}
