package com.leetcode.arrayTest.Test007;

public class Solution {
    public static void main(String[] args) {
        int x = -21;
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        // 将整数x不断对10进行取余
        int result = 0;
        while(x != 0) {
            int remainder = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10) return 0;
            if (result < Integer.MIN_VALUE / 10) return 0;
            result = result * 10 + remainder;
        }
        return result;
    }
}
