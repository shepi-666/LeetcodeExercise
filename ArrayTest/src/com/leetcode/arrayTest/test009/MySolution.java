package com.leetcode.arrayTest.test009;

public class MySolution {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        String s = x + "";
        for(int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
