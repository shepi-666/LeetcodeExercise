package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-19 10:07
 * @description:
 */
public class T58LastWorld {

    /**
     * 使用API的方法
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String trimS = s.trim();
        String[] words = trimS.split(" ");
        return words[words.length-1].length();
    }


    @Test
    public void test() {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }


    /**
     * 不使用API的方法
     * @param s
     * @return
     */
    public int lengthOfLastWordI(String s) {

        int res = 0;
        // 倒序遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            // 去掉尾部的空格
            if (s.charAt(i) == ' ' && res == 0) continue;
            if (s.charAt(i) == ' ') break;
            else res++;
        }

        return res;

    }

}
