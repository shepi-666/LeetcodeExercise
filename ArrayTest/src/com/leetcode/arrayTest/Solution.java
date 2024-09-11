package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-09-04 14:23
 * @description:
 */
public class Solution {
    /**
     *
     * 20级台阶，一次1步或者两步
     */
    public int getSteps(int n) {
        int[] dp = new int[n+1];

        if (n <= 2) return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }


    @Test
    public void testSolution() {
        int n = 6;
        System.out.println(getSteps(n));


    }

}
