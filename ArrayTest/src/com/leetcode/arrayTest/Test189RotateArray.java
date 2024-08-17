package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-08-15 08:37
 * @description:
 */
public class Test189RotateArray {
    public void rotate(int[] nums, int k) {
        int begin = Math.floorMod(k, nums.length);
        int[] temp = new int[nums.length];
        int i = 0; int j = begin;
        while (j < nums.length) {
            temp[j++] = nums[i++];
        }
        j = 0;
        while (j < begin) {
            temp[j++] = nums[i++];
        }
        nums = Arrays.copyOf(temp, temp.length);
        for (int l = 0; l < nums.length; l++) {
            nums[l] = temp[l];
        }
        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateII(nums, 3);
//        reverseArr(nums, 0, nums.length-1);
    }

    /**
     * 原始数组：1 2 3 4 5 6 7
     * 反转数组：7 6 5 4 3 2 1
     * 反转[0, k mod n - 1] 区间的元素：5 6 7 4 3 2 1
     * 反转[k mod n, n - 1]区间的元素：5 6 7 1 2 3 4
     * @param nums
     * @param k
     */
    public void rotateII(int[] nums, int k) {
        int mark = k % nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, mark - 1);
        reverseArr(nums, mark, nums.length - 1);
    }

    public void reverseArr(int[] nums, int begin, int end) {
        int temp = 0;
        int med  = (begin + end) / 2;
        for (int i = begin; i <= med; i++) {
            // 交换首尾元素
            temp = nums[i];
            nums[i] = nums[end];
            nums[end--] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

}
