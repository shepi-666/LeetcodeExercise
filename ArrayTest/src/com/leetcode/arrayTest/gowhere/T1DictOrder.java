package com.leetcode.arrayTest.gowhere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: DongShaowei
 * @create: 2024-09-06 15:35
 * @description:
 */
public class T1DictOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = Integer.parseInt(in.nextLine());
        String numsStr = in.nextLine();
        String[] strNums = numsStr.split(" ");
        if (strNums == null || strNums.length != n) {
            System.out.println("error");
            return;
        }

        Arrays.sort(strNums, String::compareTo);
        for (int i = 0; i < n; i++) {
            System.out.print(strNums[i] + " ");
        }


    }
}
