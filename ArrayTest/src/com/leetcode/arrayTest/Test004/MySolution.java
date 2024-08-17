package com.leetcode.arrayTest.Test004;

/**
 * 寻找正序数组的中位数
 */
public class MySolution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 ==0 && l2 == 0) return 0;
        else if (l1 == 0) {
            return midNumber(nums2);
        } else if (l2 == 0){
            return midNumber(nums1);
        }
        int[] nums = mergeArrays(nums1, nums2);
        return midNumber(nums);
    }

    public static double midNumber(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length/2-1] + nums[length/2]) / 2.0;
        } else {
            return nums[length / 2];
        }
    }

    public static int[] mergeArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        int i = 0; int j = 0; int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        if (i < nums1.length) {
            while (i < nums1.length) {
                nums[k++] = nums1[i++];
            }
        } else {
            while (j <nums2.length) {
                nums[k++] = nums2[j++];
            }
        }
        return nums;
    }
}
