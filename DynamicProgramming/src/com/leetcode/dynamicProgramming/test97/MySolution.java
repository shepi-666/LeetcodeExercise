package com.leetcode.dynamicProgramming.test97;
/* 97 交错字符*/
public class MySolution {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // 首先定义三个索引i,j,k
        int i = 0, j = 0, k = 0;
        // 判断字符串长度为0的情况
        if (s3.length() == 0) {
            if (s1.length() == 0 && s2.length() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (s1.length() == 0 && s2.length() == 0) {
            return false;
        }

        while (k < s3.length()) {
            // 最容易出问题的就是母串中有较长的相同位置
            int temp = k;
            if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
                k++; i++;
            } else if (s3.charAt(k) == s2.charAt(j)) {
                k++; j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
