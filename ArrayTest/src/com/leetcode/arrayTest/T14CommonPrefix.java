package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-19 10:26
 * @description:
 */
public class T14CommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i <= strs[0].length()-1; i++) {
            if (isSameChar(strs, i)) {
                prefix.append(strs[1].charAt(i));
            } else {
                break;
            }
        }
        return prefix.toString();

    }

    public boolean isSameChar(String[] strs, int index) {
        boolean flag = true;
        for (int i = 1; i < strs.length; i++) {
            if (index < strs[i].length() && strs[i].charAt(index) == strs[0].charAt(index)) continue;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }


    @Test
    public void test() {
        String[] strs = {"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(strs));
    }
}
