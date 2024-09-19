package com.top150.hashmap;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 14:52
 * @description:
 */
public class T242Anagram {
    public boolean isAnagram(String s, String t) {
        int[] codeBook = new int[26];
        Arrays.fill(codeBook, 0);
        for (char c : s.toCharArray()) {
            codeBook[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            if (codeBook[c - 'a'] == 0) {
                return false;
            }
            codeBook[c - 'a']-- ;
        }

        // 检查codeBook是否为0
        for (int i : codeBook) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testSolution() {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }
}
