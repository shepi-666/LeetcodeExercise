package com.leetcode.arrayTest.mihoyo;

import java.util.Scanner;

/**
 * @author: DongShaowei
 * @create: 2024-09-07 16:24
 * @description:
 */
public class T1ForSix {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] range = line.split(" ");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        System.out.println(mostSix(start, end));
    }


    /**
     * 找到两数之间含4或者6最多并且最大的数
     * @param start
     * @param end
     * @return
     */
    public static int mostSix(int start, int end) {
        int maxCounts = 0;
        int maxVal = 0;
        for (int i = start; i <= end; i++) {
            int counts = 0;
            String numStr = String.valueOf(i);
            for (int j = 0; j < numStr.length(); j++) {
                if (numStr.charAt(j) == '4' || numStr.charAt(j) == '6') {
                    counts++;
                }
            }
            if (maxCounts <= counts) {
                maxCounts = counts;
                maxVal = i;
            }
        }
        return maxVal;
    }

}
