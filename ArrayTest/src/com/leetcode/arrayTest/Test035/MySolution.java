package com.leetcode.arrayTest.Test035;

// 35. 搜索插入位置(二分法)
// 二分法还不熟练

public class MySolution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 9};
        System.out.println(searchInsert(nums, 7));
    }


    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) {
            return nums.length;
        } else if (target <= nums[0]) {
            return 0;
        } else {
            return searchBinary(nums, target);
        }
    }
    public static int searchBinary(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int midIndex;
        while(startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            } else if (nums[midIndex] < target) {
                // startIndex值的更新
                startIndex = midIndex + 1;
            } else  {
                // endIndex值的更新
                endIndex = midIndex - 1;
            }
        }
        // 没有找到数据的返回值一定要确定好
        return startIndex;
    }
}
