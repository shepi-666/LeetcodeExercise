package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-17 10:07
 * @description:
 */
public class T42RainWater {
    public int trap(int[] height) {
        if (height.length<= 2) return 0;
        int peak1 = 1; int peak2 = 0; int bottom = 0;
        int water = 0;

        while (peak1 < height.length) {

            int tempHeight = 0;
            // 找到第一个谷底
            while (peak1 < height.length && height[peak1] - height[peak1 - 1] <= 0) peak1++;
            bottom = peak1 - 1;

            // 找到第一个谷峰
            while (peak1 < height.length && height[peak1] - height[peak1 - 1] >= 0) peak1++;

            // 什么样的谷可以装雨水？两个谷峰，一个谷底处于不同的位置
            if (peak1 < height.length && peak1 != peak2 && peak1 != bottom && peak2 != bottom) {
                // 得到三个坐标 peak1-1, bottom, peak1
                peak1--; //回退到谷峰位置
                tempHeight = Math.min(height[peak2], height[peak1]);
                peak2++; // 前进到非谷峰的位置
                // peak2遍历到 peak1-1
                while (peak2 < peak1) {
                    int increments = tempHeight - height[peak2++];
                    water += Math.max(increments, 0);
                }
            } else {
                peak2 = peak1 - 1;
            }

        }
        return water;
    }



    @Test
    public void test() {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));

    }




    // 双指针解法
    // 注意到动态规划中
    // 对于位置 i 的接水量取决于 leftMax 和 rightMax 中的较小者
    // 所以我们不必真的知道较大者是谁
    // 只要知道较小者是谁就可以了

    // 初始化 left = 0, right = n-1, leftMax = 0, rightMax = 0
    // 注意到对于位置 left 来说, leftMax 是真正意义上的左侧最大值, 而 rightMax 不是真的右侧最大值
    // 而对于位置 right 来说, rightMax 是真正意义上的右侧最大值, 而 leftMax 不是真的左侧最大值

    // 从左往右扫描
    // 1. 使用 height[left] 和 height[right] 更新 leftMax, rightMax
    // 2. 若 height[left] < height[right], 则说明对于位置 left 来说,
    //     leftMax 一定小于其右侧真正意义上的最大值
    //     因为连当前右侧的局部最大值 rightMax 都比不过, 更比不过右侧真正意义上的最大值
    //     而我们又不需要真的知道右侧真正意义上的最大值
    // 3. 类似地处理 height[left] >= height[right] 的情况

    public int trapI(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        // 如果添加等于，则会造成一个柱子统计两次
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 当前高度小于左边的最大高度
            if (height[left] < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                // 统计右边的雨水
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
