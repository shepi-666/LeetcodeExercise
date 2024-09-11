package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-19 10:51
 * @description:
 */
public class T151ReverseWords {
    public String reverseWords(String s) {
        String trimS = s.trim();
        String[] words = trimS.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!"".equals(words[i])) res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    }

    @Test
    public void test() {
        String s = "a good    example  ";
        System.out.println(reverseWords(s));
    }
}
