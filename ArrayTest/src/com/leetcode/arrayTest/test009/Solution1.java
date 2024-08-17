package com.leetcode.arrayTest.test009;

public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int revX = reverse(x);
        return revX == x;
    }

    // 将一个整数反转的方法
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + remainder;
        }
        return result;
    }
}
