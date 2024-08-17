package com.leetcode.dynamicProgramming.test005;

public class Solution1 {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 定义一个用来保存字串起始点和终点坐标的数组
        int[] range = new int[2];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            i = findLongest(chars, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    // 用来寻找回文字串的方法
    public static int findLongest(char[] chars, int low, int[] range) {
        // 首先我们先找出来和i相同的最后一个字符的位置
        int high = low;
        while (high < chars.length - 1 && chars[low] == chars[high + 1]) {
            high++;
        }
        // 这里，我们就拿到了中间相同的字符串
        // 返回最后一个和low相同的元素的下标
        int retValue = high;
        // 我们将low和high分别向左和向右进行扩散
        while (low > 0 && high < chars.length - 1) {
            if (chars[low - 1] == chars[high + 1]) {
                low--; high++;
            } else {
                break;
            }
        }
        if (high - low > range[1] - range[0]) {
            range[1] = high;
            range[0] = low;
        }
        return retValue;
    }
}
