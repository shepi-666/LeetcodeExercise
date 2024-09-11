package com.javadong.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-08-26 11:15
 * @description:
 */
public class T167TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        res[0] = i + 1;
        res[1] = j + 1;
        return res;
    }


    @Test
    public void testSolution() {
        int[] nums = {-52,-47,-30, 0, 4, 40, 100};
        int target = -7;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    /**
     * 看到有序数组，一定想到使用二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumII(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            // 固定 i 位置的数
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low; // 中间值的坐标
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

}
