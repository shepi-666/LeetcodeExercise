package com.javadong.string;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-26 10:00
 * @description:
 */
public class T125Palindrome {
    public boolean isPalindrome(String s) {
        // 去重，移出所有的非小写字母字符
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c + 32 >= 'a' && c + 32 <= 'z') || (c >= '0' && c <= '9')) {
                if ((c + 32 >= 'a' && c + 32 <= 'z')) {
                    builder.append((char)(c + 32));
                } else {
                    builder.append(c);
                }
            }
        }
        String trimString = builder.toString();
        int i = 0; int j = trimString.length() - 1;
        while (i < j) {
            if (trimString.charAt(i) == trimString.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testSolution() {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }


    public boolean isPalindromeII(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

}
