package com.leetcode.arrayTest.Test026;

// 移除重复元素
public class MySolution {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3, 3, 4};
        int count = removeDuplicates(array);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t", array[i]);
        }

    }



    public static int removeDuplicates(int[] nums) {
        // 首先假定这个数组是非空的，因此不重复的元素的个数肯定是大于等于1
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // 对数组元素进行遍历
            // 数组元素就像是波形一样，我们选择在跳变点上对count进行加1
            if (nums[i] != nums[i + 1]) {
                // 最初数组的第一个元素是原始数据，发生第i次跳变的时候，我们将跳变之后的值存入到nums[i]中
                nums[count++] = nums[i+1];
            }
        }
        return nums.length > 0 ? count : 0;

    }
}
