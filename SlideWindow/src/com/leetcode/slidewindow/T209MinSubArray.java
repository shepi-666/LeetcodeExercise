package com.leetcode.slidewindow;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-09-12 16:13
 * @description: 长度最小的数组
 */
public class T209MinSubArray {

    /**
     * 1.排序
     * 2.找到最大的，如果大于，直接返回
     * 3.找不到就从最右边开始滑动窗
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 排序
        Arrays.sort(nums);

        int curSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum += nums[i];
            if (curSum >= target) {
                return nums.length - i;
            }
        }

        return 0;
    }

    @Test
    public void testSolution() {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLenI(target, nums));
    }


    /**
     * 根据题目要求应该是不能排序的、
     * 使用双指针
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLenI(int target, int[] nums) {

        // 特殊情况
        if (nums.length  == 1) {
            return target <= nums[0] ? 1 : 0;
        }

        int curSum = nums[0];
        int minLen = Integer.MAX_VALUE;
        int i = 0; int j = 0;
        while (j < nums.length) {
            if (curSum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                curSum -= nums[i++]; // 左边界内收
            } else {
                if (++j < nums.length) {
                    curSum += nums[j];
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
