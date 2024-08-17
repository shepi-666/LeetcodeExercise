package com.leetcode.arrayTest.Test001;

/*
    在已知数组中找出两个数之和为目标数，最容易想到的方法就是使用双层for循环暴力求解
    * 在for循环第一层，我们先拿到一个数
    * 第二层for循环就是为了寻找数组中剩余的数中是否存在(target - num)

    思考：
    我们是否可以省略掉第二层for循环，直接判断出(target - num) 是否存在？

    可以
    我们可以将数组元素的下标和值存入到HashMap中，使用contains()函数来判断sub的值是否存在

 */


import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {3, 3, 6};
        int[] solution = twoSum(nums, 9);
        System.out.printf("%d\t%d\t", solution[0], solution[1]);

    }


    public static int[] twoSum(int[] nums, int target) {
        // 建立一个哈希表
        Map<Integer, Integer> map = new HashMap<>();

        int[] solution = new int[2];

        // 使用for循环给哈希表赋值
        for (int i = 0; i < nums.length; i++) {
            // 值存入到key部分，下标存入到value部分
            map.put(nums[i], i);
        }

        // 查找算法
        // 先使用for循环获取某一个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算和目标值的差值

            // Map集合中没有通过value获取key的方法
            //int sub = target - (int)map.get(i);
            int sub = target - nums[i];

            // 判断sub是否存在于哈希表的key部分
            if (map.containsKey(sub) && map.get(sub) != i) {
                solution[0] = i;
                solution[1] = map.get(sub);
                return solution;
            }
        }
        throw new IllegalArgumentException("没有找到两数之和为目标数");

    }
}
