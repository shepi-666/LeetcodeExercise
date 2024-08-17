package com.leetcode.dynamicProgramming.test131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        String s = "abbab";
        List<List<String>> ans = partition(s);
        for(List<String> list : ans) {
            System.out.println(list);
        }
    }
    public static List<List<String>> partition(String s) {
        // 关于dp数组的建立
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 根据老夫做动态规划的题，动态规划总是假设当前状态是成立的来
        // 建立过去值和现在值的关系
        // 假设dp[i][j]是一个回文串，那么也就是说肯定有char[i] == char[j] && dp[i + 1][j - 1]成立
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        return partition(s, 0, dp);
    }

    // 这里我们对解1进行优化
    // 在判断回文串的时候我们可以使用dp数组来存储回文串的位置
    public static List<List<String>> partition(String s, int start, boolean[][] dp) {
        // 依旧是递归的出口
        if (start == s.length()) {
            List<List<String>> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            ans.add(list);
            return ans;
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                for (List<String> list : partition(s, i + 1, dp)) {
                    list.add(0, left);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
