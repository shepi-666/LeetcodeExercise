package com.leetcode.dynamicProgramming.test70;
/*
* 70. 爬楼梯
*
* */
public class MySolution {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        return getNumOfMethod(n);
    }

    /**
     * num 方法的个数
     * n 楼梯的阶数
     */
/*
    public static int getNumOfMethod(int n, int num) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return num + getNumOfMethod(n - 1, num + 1) + getNumOfMethod(n - 2, num + 1);
    }
*/
    public static int getNumOfMethod(int n) {
        if (n <= 2) return n;
        else return getNumOfMethod(n - 1) + getNumOfMethod(n - 2);
    }

}
