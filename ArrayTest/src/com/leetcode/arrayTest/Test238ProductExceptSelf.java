package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-08-16 10:41
 * @description:
 */
public class Test238ProductExceptSelf {

    /**
     * 两个数组，分别存储当前数的前驱乘积和后继乘积
     * 将两个数组进行相乘
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        int[] next = new int[n];
        next[n-1] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] * nums[i-1];
            next[n-1-i] = next[n-i] * nums[n-i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = pre[i] * next[i];
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }


}
