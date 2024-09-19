package com.top150.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 17:06
 * @description: 最长连续序列
 */
public class T128LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int maxLen = 1;
        if (nums.length <= 1) return nums.length;
        // nums中可能有重复的，需要去重操作
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        List<Integer> distinctList = new ArrayList<>(numSet);
        int[] distinctNums = new int[distinctList.size()];
        for (int i = 0; i < distinctNums.length; i++) {
            distinctNums[i] = distinctList.get(i);
        }
        Arrays.sort(distinctNums);

        int i = 0; int j = 1;
        while (j < distinctNums.length) {
            while (j < distinctNums.length && distinctNums[j] - distinctNums[j - 1] == 1) {
                j++;
            }
            maxLen = Math.max(j - i, maxLen);
            i = j++; // 新序列的第一个位置和第二个位置
        }


        return maxLen;


    }

    @Test
    public void testSolution() {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveI(nums));
    }


    /**
     * 使用 o(n)的算法优化
     * @param nums
     * @return
     */
    public int longestConsecutiveI(int[] nums) {


        if (nums.length <= 1) return nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int j : nums) {
            numSet.add(j);
        }
        int maxLen = 1;

        for (int num : nums) {

            // 当前值为序列头
            if (!numSet.contains(num - 1)) {
                int nextNum = num + 1;
                int curLen = 1;
                // 下一个值能够续上
                while (numSet.contains(nextNum)) {
                    curLen++;
                    nextNum++;
                }
                maxLen = Math.max(curLen, maxLen);
            }
        }
        return maxLen;
    }
}
