package com.javadong.string;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-26 10:35
 * @description:
 */
public class T392Subsequence {
    public boolean isSubsequence(String s, String t) {

        int i = 0; int j = 0;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++; j++;
            }
        }
        return i >= s.length();
    }


    @Test
    public void testSolution() {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    /**
     * 动态规划，f[i][j]表示从索引 i 开始 第 j 个小写字母出现的位置索引
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceII(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m; // 如果出现m表示没有出现过该字母
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i; // 索引 i 开始后的 j 字母出现的第一个位置委 i
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }


}
