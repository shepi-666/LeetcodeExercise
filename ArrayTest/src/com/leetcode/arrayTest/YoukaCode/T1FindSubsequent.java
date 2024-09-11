package com.leetcode.arrayTest.YoukaCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: DongShaowei
 * @create: 2024-09-04 19:15
 * @description:
 */
public class T1FindSubsequent {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int LongestConsecutive (int[] nums) {
        // write code here
        if (nums.length <= 1) return nums.length;
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int maxLen = 0;
        int i = 0; int j = 1;
        while (i < sorted.length && j < sorted.length) {
            int curLen = 0;
            while (j < sorted.length && sorted[j] - sorted[i] == j - i) {
                j++;
            }
            curLen = j - i;
            maxLen = Math.max(curLen, maxLen);
            i = j;
            j++;
        }
        return maxLen;

    }


    @Test
    public void testSolution() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(LongestConsecutive(nums));
    }
}
