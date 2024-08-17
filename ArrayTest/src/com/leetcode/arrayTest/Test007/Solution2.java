package com.leetcode.arrayTest.Test007;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Math.floor(Math.log10(4500)) + 1);
    }
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int digital = (int)Math.floor(Math.log10(x)) + 1;
        int revR = 0;
        // 反转后面的部分
        for (int i = 0; i < digital / 2; i++) {
            int remainder = x % 10;
            x = x / 10;
            revR = revR * 10 + remainder;
        }
        if (digital % 2 == 0) {
            return x == revR;
        } else {
            return x / 10 == revR;
        }

    }
}
