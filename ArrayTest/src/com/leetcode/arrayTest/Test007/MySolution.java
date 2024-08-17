package com.leetcode.arrayTest.Test007;

public class MySolution {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        // 先将整形数字转换为字符串
        String s = x + "";
        char[] newChars = null;
        char[] chars = s.toCharArray();
        if (chars[0] == 45) {
            newChars = new char[chars.length - 1];
            for (int i = 0; i < chars.length-1; i++) {
                newChars[i] = chars[chars.length - 1 - i];
            }
        } else {
            newChars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                newChars[i] = chars[chars.length - 1 - i];
            }
        }


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newChars.length; i++) {
            result.append(newChars[i]);
        }
        String ret = result.toString();
        String mod = null;
        if (chars[0] == 45) {
            if (newChars.length == 10) {
                mod = (int) Math.pow(2, 31) + "";
                return ret.compareTo(mod) > 0 ? 0 : -Integer.parseInt(ret);
            } else {
                return -Integer.parseInt(ret);
            }
        } else {
            if (newChars.length == 10) {
                mod = (int)Math.pow(2, 31) - 1 + "";
                return ret.compareTo(mod) > 0 ? 0 : Integer.parseInt(ret);
            } else {
                return Integer.parseInt(ret);
            }
        }
    }
}
