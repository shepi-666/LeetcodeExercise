package com.leetcode.arrayTest.Test001;

// 两数之和

public class Test001 {

    public static void main(String[] args) {
        int[] testArray = {3, 3};
        int[] solution = twoSum(testArray, 6);
        System.out.printf("%d\t%d\t", solution[0], solution[1]);

    }


    public static int[] twoSum(int[] nums, int target) {
        // 创建解数组
        int[] solution = new int[2];

        // 简单暴力：双层for循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }

        throw new IllegalArgumentException("目标值输出有误");
    }
}
