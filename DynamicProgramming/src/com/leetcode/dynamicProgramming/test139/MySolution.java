package com.leetcode.dynamicProgramming.test139;

/* 139.单词拆分
* 给定一个非空字符串s和一个包含非空单词的列表，
* 判断s是否可以被空格拆分为一个或者多个在字典中的单词
*  */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        String s = "leetcode";
        System.out.println(wordBreak(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态转移方程：dp[i] = dp[i - n] && map.containsKey(substring(i - n + 1, i + 1))
        // 以i为结尾的字符串可以被拆分的条件是：这个单词在词典中并且前面的字符串可以被拆分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
