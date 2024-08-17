package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-16 08:15
 * @description:
 */
public class Test45JumpGame {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int step = 0;
        int r = nums[0];
        int l = 0;
        int[] temp;
        while (true) {
            if (r >= nums.length - 1) {
                step++;
                break;
            }
            // 找到下一步的最大步数
            temp = findMaxValue(nums, l, r);
            l = temp[0];
            r = temp[1];
            step ++;

        }
        return step;

    }

    // 寻找局部最大值的坐标
    public int[] findMaxValue(int[] nums, int l, int r) {
        int maxIndex = 0;
        int maxVal = 0;
        int[] retArr = new int[2];
        for (int i = l; i <= r; i++) {
            if (i + nums[i] > maxVal) {
                maxVal = i + nums[i];
                maxIndex = i;
            }
        }
        retArr[0] = maxIndex;
        retArr[1] = maxVal;
        return retArr;
    }

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

}
