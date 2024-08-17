package com.leetcode.dynamicProgramming.test62;
/* 62. 不同路径 */
public class MySolution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
    public static int uniquePaths(int m, int n) {
        long molecular = 1, denominator = 1;
        int max = Math.max(m - 1, n - 1);
        int min = Math.min(m - 1, n - 1);
        for (int i = max + min; i > max; i--) {
            molecular = i * molecular;
        }
        for (int i = 1; i <= min; i++) {
            denominator = denominator * i;
        }
        return (int)(molecular / denominator);
    }
}
