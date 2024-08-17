package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-15 10:43
 * @description:
 */
public class Test55JumpGame {

    /**
     * 使用递归的方法，超时
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }
    public boolean jump(int[] nums, int cur) {
        if (cur == nums.length - 1) return true;
        boolean flag = false;
        for (int i = 1; i <= nums[cur]; i++) {
            flag = flag || jump(nums, cur + i);
            if (flag) break;;
        }
        return flag;

    }

    @Test
    public void test() {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    /**
     * 可达性分析
     * @param nums
     * @return
     */
    public boolean canJumpI(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }

            if (maxIndex >= n-1) return true;
        }

        return false;
    }

}
