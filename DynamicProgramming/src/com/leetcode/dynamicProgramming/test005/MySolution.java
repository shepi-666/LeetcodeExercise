package com.leetcode.dynamicProgramming.test005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 5. 最长回文子串 */
public class MySolution {
    public static void main(String[] args) {
        String s = "abcdeedcac";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        ArrayList<String> strList = new ArrayList<>();
        char[] chars = s.toCharArray();
        int j = chars.length - 1;
        for (int i = 0; i < chars.length - 1; i++) {
            while (i < j) {
                if (match(chars, i, j)) {
                    strList.add(s.substring(i, j + 1));
                }
                j--;
            }
            j = chars.length - 1;
        }
        if (strList.size() == 0) {
            return s.substring(0, 1);
        } else {
            Collections.sort(strList, new SortByLength());
            return strList.get(0);
        }

    }

    public static boolean match(char[] chars, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            boolean matched = false;
            if (chars[startIndex] == chars[endIndex]) {
                matched = match(chars, startIndex + 1, endIndex - 1);
            }
            return matched;
        } else {
            return true;
        }

    }
}

class SortByLength implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return -1;
        } else if (o1.length() == o2.length()) {
            return 0;
        } else {
            return 1;
        }
    }
}
