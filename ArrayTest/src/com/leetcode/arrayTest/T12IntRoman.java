package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-08-19 09:14
 * @description:
 */
public class T12IntRoman {
    public String intToRoman(int num) {
        String number = String.valueOf(num);
        Stack<String> resStack = new Stack<>();

        // 如何将数拆分为9,5,4,1
        // 3749: 1000 1000 1000 500 100 100 40 9
        int unit = 1;
        for (int i = number.length()-1; i >= 0; i--) {
            int single = (number.charAt(i) - '0');

            StringBuilder tempCode = new StringBuilder();

            while (single > 0) {
                if (single - 9 >= 0) {
                    single -= 9;
                    tempCode.append(getCode(9 * unit));
                }

                if (single - 5 >= 0) {
                    single -= 5;
                    tempCode.append(getCode(5 * unit));
                }

                if (single - 4 >= 0) {
                    single -= 4;
                    tempCode.append(getCode(4 * unit));
                }

                if (single - 1 >= 0) {
                    single -= 1;
                    tempCode.append(getCode(1 * unit));
                }
            }
            resStack.push(tempCode.toString());
            unit *= 10;

        }

        StringBuilder res = new StringBuilder();

        while(resStack.size() > 0) {
            res.append(resStack.pop());
        }

        return res.toString();

    }

    public String getCode(Integer number) {
        switch (number) {
            case 1: return "I";
            case 4: return "IV";
            case 5: return "V";
            case 9: return "IX";
            case 10: return "X";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 100: return "C";
            case 400: return "CD";
            case 500: return "D";
            case 900: return "CM";
            case 1000: return "M";
        }
        return "";

    }

    @Test
    public void test() {
        System.out.println(intToRoman(3749));
    }

}
