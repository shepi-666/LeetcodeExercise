package com.leetcode.arrayTest.Test006;
/*
* 先访问 行0 的所有字符，接着访问 行1， 行2， 。。。
* 行0 的所有字符位于 k * (2 * numRows - 2)
* 行 numRows - 1 的所有字符位于 k * (2 * numRows - 2) + numRows - 1 处
* 其他内部的行i 中的字符位于k * (2 * numRows - 2) + i 和 (k + 1) * (2 * numRows - 2) - i
* */

public class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder builder =  new StringBuilder();
        int length = s.length();
        int cycleLength = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += cycleLength) {
                builder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLength - i < length)
                    builder.append(s.charAt(j + cycleLength - i));
            }
        }
        return builder.toString();
    }
}
