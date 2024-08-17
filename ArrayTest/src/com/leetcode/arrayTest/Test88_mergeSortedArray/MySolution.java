package com.leetcode.arrayTest.Test88_mergeSortedArray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-08-14 15:31
 * @description:
 */
public class MySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n > 0) {
            nums1 = nums2;
            System.out.println(Arrays.toString(nums1));
            return;
        }
        if ( m > 0 && n == 0) {
            System.out.println(Arrays.toString(nums1));
            return;
        }

        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if ( nums1[i] <= nums2[j]) temp.add(nums1[i++]);
            else temp.add(nums2[j++]);
        }

        if (i >= m) {
            while (j < n) temp.add(nums2[j++]);
        } else {
            while (i < m) temp.add(nums1[i++]);
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp.get(k);
        }

        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
    }


}
