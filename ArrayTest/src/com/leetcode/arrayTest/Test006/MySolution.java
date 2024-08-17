package com.leetcode.arrayTest.Test006;

public class MySolution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String ss = convert(s, 3);
        System.out.println(ss);
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        // 总共有几个z字
        int n = length / (2 * numRows - 2);
        int m = length % (2 * numRows - 2);
        int nums = 2 * numRows - 2;
        int l = 2 * n;
        if (m != 0) {
            if (m <= numRows) {
                l = l + 1;
            } else {
                l = l + 2;
            }
        }
        char[][] container = new char[numRows][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % 2 == 0) {
                    if (j + j + (i / 2) * nums > length - 1) break;
                    container[j][i] = s.charAt(j + (i / 2) * nums);
                } else {
                    if (nums - j + 1 + (i / 2) * nums > length - 1) break;
                    container[j][i] = s.charAt(nums - j + 1 + (i / 2) * nums);
                    container[0][i] = 0;
                    container[numRows-1][i] = 0;
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < l; j++) {
                if (container[i][j] == 0) ;
                else {
                    builder.append(container[i][j]);
                }
            }
        }
        return builder.toString();
    }
}
