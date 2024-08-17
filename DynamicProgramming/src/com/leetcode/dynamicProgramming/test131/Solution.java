package com.leetcode.dynamicProgramming.test131;

import java.util.ArrayList;
import java.util.List;

/* 131 分割回文串 */
// 使用分治算法
public class Solution {
    public static List<List<String>> partition(String s) {
        return partitionHelper(s, 0);
    }

    // 这个函数是专门进行递归的
    public static List<List<String>> partitionHelper(String s, int start) {
        // 递归结束条件就是 start == s.length()
        if (start == s.length()) {
            List<List<String>> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            // 将空串集合加入到集合中
            ans.add(list);
            // 将这个空的集合返回
            return ans;
        }

        // 执行到这里说明非空
        // 创建存储结果的集合
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            // 先判断从(start, i)是否为一个回文串
            if (isPalindrome(s, start, i)) {
                String left = s.substring(start, i + 1);
                // 我们遍历后面子串的所有分割集合，将我们这个回文串添加到他们的前面
                for (List<String> list : partitionHelper(s, i + 1)) {
                    // 将我们的这个回文串添加到集合的开始
                    list.add(0, left);
                    // 将集合添加到结果集中
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    // 判断一个子串是否为回文串的方法
    private static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++; end--;
            }
        }
        return true;
    }
}
