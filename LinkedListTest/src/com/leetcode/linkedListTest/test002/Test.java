package com.leetcode.linkedListTest.test002;

public class Test {
    public static void main(String[] args) {
        int n = 4; int num = 1174;
        for (int i = n - 1; i > 0 ; i--) {
            int m = num / (int) Math.pow(10, i);
            num = num - m * (int) Math.pow(10, i);
            System.out.printf("%d\t", m);
        }
        System.out.println(num);
    }
}
