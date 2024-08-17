package com.leetcode.dynamicProgramming.test53;
/*
*  53.给定一个整数数组nums，找到一个具有最大和的连续子数组
*  子数组中最少包含一个元素，返回其最大值
*
*  不会写
* */
public class MySolution {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }
    // 动态规划
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            result = Math.max(pre, result);
        }
        return result;
    }
}