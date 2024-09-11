package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-08-19 08:33
 * @description:
 */
public class T13RomanInt {


    /**
     * 自己的思路，就是将所有的编码放到Map中遍历，然后往后看一位
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        Map<String ,Integer> romanMap = new HashMap<>();

        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);


        int res = 0;
        int j = 1;
        for (int i = 0; i <= s.length()-1; i++) {

            if (j > s.length()-1) res += romanMap.get(s.charAt(i) + "");
             else {
                 String code = s.charAt(i) + "" + s.charAt(j);
                 if (romanMap.containsKey(code)) {
                     res += romanMap.get(code);
                     i++; j++;
                 } else {
                     res += romanMap.get(s.charAt(i) + "");
                 }
                j++;
            }
        }

        return res;

    }


    @Test
    public void test() {
        String romanNumber = "MCMXCIV";
        System.out.println(romanToInt(romanNumber));
    }


    /**
     * 使用SwitchCase判断，当前大于前面的，就做减法
     * @param s
     * @return
     */
    public int romanToIntII(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


}
