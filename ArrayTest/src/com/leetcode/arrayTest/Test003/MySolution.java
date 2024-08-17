package com.leetcode.arrayTest.Test003;

/**
 * 给定一个字符串s， 找出不含有重复字符串的最长字串的长度
 *
 */
public class MySolution {
    public static void main(String[] args) {
        String s = "abc";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int length = s.length();
        if (length <= 1) return s.length();
        s = s + "*";
        int i = 0; int j = i + 1;
        int maxLength = 1;
        while (j <= length) {
            String s1 = s.substring(i, j);
            int index =  s1.indexOf(s.charAt(j));
            maxLength = Math.max(maxLength, s1.length());
            if (index != -1) {
                i = j - s1.length() + index + 1;
            }
            j++;
        }
        return maxLength;
    }

}
