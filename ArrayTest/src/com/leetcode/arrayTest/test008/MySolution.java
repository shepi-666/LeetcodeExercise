package com.leetcode.arrayTest.test008;
/*
* 数字前面只有空格
*
* 一定要注意边界条件的判定
* */

public class MySolution {
    public static void main(String[] args) {
        String s = "100000000000000000000000000000000000000000014456456";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        // 字符串非空和长度的判定
        if (s == null || s.length() == 0) return 0;
        int i = 0;
        long result = 0;
        int count = 0; // 用来表示已经添加的有效位数
        boolean posFlag = true; // 标记正负数
        if (s.charAt(i) != 32 && s.charAt(i) != 43 && s.charAt(i) != 45 && (s.charAt(i) < 48 || s.charAt(i) > 57))
            return 0; // 首字符非数学符号或者空格
        while(i < s.length() && s.charAt(i) == 32){
            i++;
        }
        if (i >= s.length()) return 0;
        if (s.charAt(i) == 45){
            posFlag = false;
        }
        if (s.charAt(i) == 45 || s.charAt(i) == 43) i++;
        while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
            if (count > 10) return posFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else {
                result = result * 10 + (s.charAt(i) - 48);
                // 如果当前结果不是0，就说明添加了有效的位数
                count = result > 0 ? count + 1 : count;
                i++;
            }
        }
        // 判断越界情况
        if (posFlag) {
            result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        } else {
            result = -1 * result;
            result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        }

        return (int) result;
    }
}
