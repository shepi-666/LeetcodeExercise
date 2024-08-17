package com.leetcode.arrayTest.Test003;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 创建长度为128的数组，记录各个字符上一次出现的位置
        int[] last = new int[128];
        // 对数组进行初始化
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            maxLength = Math.max(maxLength, i - start + 1);
            last[index] = i;
        }
        return maxLength;
    }
}
