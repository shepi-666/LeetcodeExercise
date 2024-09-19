package com.leetcode.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-12 19:12
 * @description: 无重复字符的最长字串
 */
public class T3LongestSubstring {

    /**
     * 使用双指针的方法
     * 主要思想：
     * 快慢指针，快指针添加元素，慢指针删除重复的元素
     * 元素保存在Hash表中，一定要记得将 i 和 重复元素 之间的所有元素删除
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if (s.length() <= 1) return s.length();
        int i = 0; int j = 0;
        Map<Character ,Integer> dictMap = new HashMap<>();
        while (true) {

            while (j < s.length() &&  !dictMap.containsKey(s.charAt(j))) {
                dictMap.put(s.charAt(j), j++);
            }

            // 说明已经出现了重复的情况，或者是到头的情况
            maxLen = Math.max(maxLen, j - i);
            if (j == s.length()) return maxLen;

            // 清除掉HashMap中重复的元素
            int nextJump = dictMap.get(s.charAt(j));
            while (i <= nextJump) {
                dictMap.remove(s.charAt(i++));
            }
            dictMap.put(s.charAt(j), j++);
        }
    }


    @Test
    public void testSolution() {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
