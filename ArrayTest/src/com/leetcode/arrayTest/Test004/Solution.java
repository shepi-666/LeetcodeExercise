package com.leetcode.arrayTest.Test004;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int left = (l1 + l2 + 1) / 2;
        int right = (l1 + l2 + 2) / 2;

        return (findKth(nums1, 0, nums2, 0, left) +
                findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }


    /**
     *
     * @param nums1 数组1
     * @param i 数组1开始寻找的坐标
     * @param nums2 数组2
     * @param j 数组二开始的索引
     * @return
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1) < nums2.length ? nums2[i + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2 - 1, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2 - 1, k - k / 2);
        }
    }
}
