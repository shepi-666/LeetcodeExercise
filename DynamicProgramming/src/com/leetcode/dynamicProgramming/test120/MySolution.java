package com.leetcode.dynamicProgramming.test120;

import java.util.ArrayList;
import java.util.List;

/* 120 三角最短路径和
*  */
public class MySolution {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(minimumTotal(list));

    }

    // 如果使用贪心算法的话，我们选择每一步都是最小值，这个解肯定不符合题意，因为使用贪心算法只是局部的最优解
    // 使用动态规划呢？
    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int minPath = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            minPath = Math.min(minPath, dp[n - 1][i]);
        }
        return minPath;
    }
}
