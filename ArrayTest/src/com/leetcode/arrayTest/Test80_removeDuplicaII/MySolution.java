package com.leetcode.arrayTest.Test80_removeDuplicaII;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-08-14 16:55
 * @description:
 */
public class MySolution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 0; int j = 0; int k = 0;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[k]) {
                j++;
            } else {
                if (j - k >= 2) {
                count++;
                nums[++i] = nums[k];
            }
                nums[++i] = nums[j];
                k = j;
                count++;
            }
        }
        if (j - k >= 2) {
            nums[++i] = nums[k];
            count++;
        }
        System.out.println(Arrays.toString(nums));
        return count;

    }

    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(removeDuplicatesII(nums));
    }

    public int removeDuplicatesII(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int slow = 2, fast = 2;
        while(fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) nums[slow++] = nums[fast];
            fast ++;
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }
}
