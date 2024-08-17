package com.leetcode.dynamicProgramming.test152;

public class MySolution {
    public static void main(String[] args) {

        int[] nums = {-2, 0, -4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int temp = 1;

        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
            maxProduct = Math.max(maxProduct, temp);
            if (nums[i] == 0){
                temp = 1;
            }
        }
        temp = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            temp *= nums[i];
            maxProduct = Math.max(maxProduct, temp);
            if (nums[i] == 0) {
                temp = 1;
            }
        }
        return maxProduct;
    }
}
