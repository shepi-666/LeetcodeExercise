package com.leetcode.stackTest.test155;
/*
* 155. 最小栈
* 设计一个支持push(), pop(), top()操作并且能够在常数时间内检索到最小元素的栈
* push(x)， 将元素x推入栈中
* pop() 删除栈顶的元素、
* top() 返回栈顶的元素
* getMin() 检索栈中的最小元素
*/

// 自己写的这个栈最大的毛病是：
// 1. 不可以扩容
// 2. 获取栈中最小元素的时候空间复杂度太高
public class MyStack {
    // 创建一个原始容量为10的数组
    int[] array = new int[10];
    // 栈顶的指针
    private int pointer = -1;

    // 构造方法
    public MyStack () { }

    // 压栈方法
    public void push(int val) {
        if (getSize() == 10) throw new RuntimeException("压栈失败，栈已满");
        else array[++pointer] = val;

    }

    // 弹栈方法
    public void pop() {
        if (getSize() == 0) throw new RuntimeException("弹栈失败，栈已空");
        else array[pointer--] = 0;
    }

    // 获取栈顶元素的方法
    public int top() {
        return array[pointer];
    }

    // 获取栈中最小元素的方法
    public int getMin() {
        int temp = array[0];
        for (int i = 0; i < getSize(); i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    // 获取栈中元素个数的方法
    public int getSize() {
        return pointer + 1;
    }
}

class StackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
    }
}