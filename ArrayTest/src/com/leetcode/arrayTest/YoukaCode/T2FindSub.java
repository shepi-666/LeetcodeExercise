package com.leetcode.arrayTest.YoukaCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-04 20:18
 * @description:
 */
public class T2FindSub {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int LongestArithSeqLength (int[] nums) {
        // write code here
        if (nums.length <= 1) return nums.length;

        int n = nums.length;
        int maxLen = 0;

        Map<Integer, Integer>[] sequences = new HashMap[n];

        for (int i = 0; i < n; i++) {
            sequences[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int distant = nums[i] - nums[j];
                sequences[i].put(distant, sequences[j].getOrDefault(distant, 1) + 1);
                maxLen = Math.max(maxLen, sequences[i].get(distant));
            }
        }

        return maxLen;

    }
}
