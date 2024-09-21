package com.leetcode.stackTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 17:08
 * @description: reverse Polish Notation
 */
public class T150RPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> dataStack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num1 = dataStack.pop();
                    int num2 = dataStack.pop();
                    dataStack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num1 = dataStack.pop();
                    int num2 = dataStack.pop();
                    dataStack.push(num2 - num1);
                    break;
                }
                case "*": {
                    int num1 = dataStack.pop();
                    int num2 = dataStack.pop();
                    dataStack.push(num2 * num1);
                    break;
                }
                case "/": {
                    int num1 = dataStack.pop();
                    int num2 = dataStack.pop();
                    dataStack.push(num2 / num1);
                    break;
                }
                default: {
                    dataStack.push(Integer.parseInt(token));
                }
            }
        }
        return dataStack.pop();
    }


    @Test
    public void testSolution() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPNI(tokens));
    }


    /**
     * 使用数组模拟栈来解决逆波兰表达式
     * @param tokens
     * @return
     */
    public int evalRPNI(String[] tokens) {

        // 特殊情况判断
        if (tokens.length <= 2) return Integer.parseInt(tokens[tokens.length - 1]);

        // 最多有 n / 2 + 1个操作数
        int[] dataStack = new int[tokens.length / 2 + 1];
        int index = 0; // 模拟栈帧
        for (String token : tokens) {
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
}
