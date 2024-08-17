package com.leetcode.dynamicProgramming.test131;
/* 使用回溯 + 动态规划的方法*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        String s = "abbab";
        List<List<String>> ans = partition(s);
        for(List<String> list : ans) {
            System.out.println(list);
        }
    }
    public static List<List<String>> partition(String s) {
        // 创建一个dp数组
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        // 创建一个结果数组
        List<List<String>> ans = new ArrayList<>();
        partition(ans, new ArrayList<>(), dp, s, 0);
        return ans;
    }

    public static void partition(List<List<String>> ans, List<String> temp, boolean[][] dp, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
        }

        // 想一想：回溯回溯，什么是回溯？
        // for + 递归调用
        // 我们尝试在各个不同的位置进行切割
        for (int i = start; i < s.length(); i++) {
            // 判断是否为回文串
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                // 将这个回文串添加到temp中
                temp.add(left);
                // 对后面的进行递归
                partition(ans, temp, dp, s, i + 1);
                // 因为要进行下一次的回溯
                // 所以我们将本次添加的回文串删除
                temp.remove(temp.size() - 1);
            }
        }
    }
}
