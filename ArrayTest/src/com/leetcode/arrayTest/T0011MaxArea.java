package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-09-11 16:36
 * @description: T11 盛水最多的容器
 */
public class T0011MaxArea {

    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int maxArea = 0;

        for (int i = 0; i <= height.length - 2; i++) {
            for (int j = i + 1; j <= height.length - 1; j++) {
                int curHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, curHeight * (j - i));
            }
        }
        return maxArea;
    }


    public int maxAreaI(int[] height) {
        if (height.length <= 1) return 0;
        int maxArea = 0;

        int l = 0; int r = height.length - 1;

        while (l < r) {
            int curHeight = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, curHeight * (r - l));
            // 移动指针方向
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }


        return maxArea;
    }

    @Test
    public void testSolution() {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaI(nums));
    }
}
