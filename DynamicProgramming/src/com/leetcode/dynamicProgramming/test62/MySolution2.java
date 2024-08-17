package com.leetcode.dynamicProgramming.test62;

/* 使用递归的方式求解，但是肯定是无法通过的，超时*/
public class MySolution2 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }
}
