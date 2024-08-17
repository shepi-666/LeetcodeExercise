package com.leetcode.dynamicProgramming.test303;
/* 303. 区域搜索——数组不可变*/
public class MySolution {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(0, 2));
    }


}

class NumArray {
    public int[] sum;
    public NumArray(int[] nums) {
        if (nums == null) sum = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
           sum[i] = sum[i - 1] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return left == 0 ? sum[right] : sum[right] - sum[left - 1];
    }
}