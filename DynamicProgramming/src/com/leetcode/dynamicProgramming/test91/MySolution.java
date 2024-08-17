package com.leetcode.dynamicProgramming.test91;
/* 91. 解码方法 */
public class MySolution {
    public static void main(String[] args) {
        String s = "1123";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || Integer.parseInt(s.substring(0, 1)) == 0) {
            return 0;
        }
        int length = s.length();
        if (length == 1) return 1;
        int[] dp = new int[length];
        // 对dp数组赋初值
        int temp = Integer.parseInt(s.substring(0, 2));
        if (temp > 26 || temp == 20 || temp == 10) {
            dp[1] =  1;
        } else {
            dp[1] = 2;
        }

        int cur, pre;
        for (int i = 2; i < length; i++) {

            cur = s.charAt(i) - 48;
            pre = s.charAt(i - 1) - 48;

            // 当前数字不为0
            if (cur != 0) {
                // 无法和前面的数字进行组合，独自美丽
                if (pre == 0 || pre > 2) {
                    dp[i] = dp[i - 1];
                } else {
                    // 可以和前面的数字进行组合，也可以独自美丽
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                // 当前数字为0,并且无法和前面的数字进行组合
                if (pre == 0 || pre > 2) {
                    return 0;
                } else {
                    // 可以和前面的数字进行组合
                    dp[i] = dp[i - 2];
                }
            }
        }
        return dp[length - 1];
    }
}
