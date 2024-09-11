package com.leetcode.arrayTest;

/**
 * @author: DongShaowei
 * @create: 2024-08-25 10:16
 * @description:
 */
public class T0028KMP {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0; // 主串
        int j = 0; // 字串

        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else {
                j = next[j];
            }
            if ( j == needle.length()) return i - j;
        }

        return -1;
    }

    private int[] getNext(String needle) {
        int n = needle.length();
        int j = 0; // 主串指针，不回溯
        int k = -1; // 子串指针
        int[] next = new int[n];
        next[0] = -1;

        // 模式串对自身进行匹配
        while (j < n-1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) { // 匹配成功，或者刚开始匹配
                k++; j++;
                next[j] = k; // 表示最长公共前后缀的长度 回溯指针为第一个不满足的，正好是 k - 1 + 1
            } else {
                k = next[k]; // 回溯到最长公共前后缀的地方
            }
        }
        return next;
    }
}
