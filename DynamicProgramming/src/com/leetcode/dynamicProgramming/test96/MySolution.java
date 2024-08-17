package com.leetcode.dynamicProgramming.test96;
/* 96 不同的二叉搜索树 */
public class MySolution {
    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }

    public static int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i / 2; j++) {
                nums[i] = nums[i] + 2 * nums[j] * nums[i - 1 - j];
            }
            if (i % 2 == 1) {
                nums[i] += nums[i / 2] * nums[i / 2];
            }
        }
        return nums[n];
    }
}
