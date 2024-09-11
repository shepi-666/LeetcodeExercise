package com.leetcode.arrayTest.giantNet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-06 19:30
 * @description:
 */
public class T1ThreeSum {


    /**
     * 三数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        // 暴力循环
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        resList.add(res);
                    }
                }
            }
        }
        return resList;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 7, 8, 5, 2};
        int target = 11;
        List<List<Integer>> resList = threeSumII(nums, target);
        if (!resList.isEmpty()) {
            for (List<Integer> res : resList) {
                System.out.println(res.toString());
            }
        }
    }

    public List<List<Integer>> threeSumII(int[] nums, int target) {

        List<List<Integer>> resList = new ArrayList<>();

        // 将每个元素和其余元素存入到Map中，键是当前元素，值是其余的元素
        Map<Integer, Map<Integer, Integer>> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {

                if (j != i) {
                    temp.put(j, nums[j]);
                }
            }
            targetMap.put(i, temp);
        }

        // 对哈希表进行遍历
        for (Map.Entry<Integer, Map<Integer, Integer>> tempMap : targetMap.entrySet()) {
            // 分别获取键值
            int curIndex = tempMap.getKey();
            Map<Integer, Integer> remainders = tempMap.getValue();
            int firstMen = nums[curIndex];

            // 对目标数做两数之和
            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                if (i != curIndex) {
                    // 获取第一个值
                    int secMan = nums[i];
                    // 获取剩余值的Map集合
                    int thirdMan = target - firstMen - secMan;
                    if (remainders.containsValue(thirdMan)) {
                        List<Integer> res = new ArrayList<>();
                        res.add(firstMen);
                        res.add(secMan);
                        res.add(thirdMan);
                        resList.add(res);


                    }
                }
            }
        }

        // 如何实现去重呢？


        return resList;


    }


}
