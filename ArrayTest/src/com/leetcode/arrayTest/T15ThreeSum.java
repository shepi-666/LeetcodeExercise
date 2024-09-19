package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-12 15:18
 * @description: 三数之和
 */
public class T15ThreeSum {

    /**
     * beats 5%
     * 主要思路：
     * 1.排序
     * 2.定住一个数 i
     * 3.双指针i+1 length-1，往中间遍历，符合条件加入到Map中，去重
     * 4.返回
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resList = new ArrayList<>();
        Map<String, List<Integer>> distinctMap = new HashMap<>();
        // 从左到右固定一个，然后双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    String key = nums[i] + "" + nums[j] + nums[k];
                    distinctMap.putIfAbsent(key, res);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        // 对Map遍历
        for (Map.Entry<String, List<Integer>> res : distinctMap.entrySet()) {
            resList.add(res.getValue());
        }

        return resList;
    }

    @Test
    public void test() {
        int[] nums = {0,0,0};
        List<List<Integer>> lists = threeSumI(nums);
        for (List<Integer> res : lists) {
            System.out.println(res.toString());
        }
    }

    public List<List<Integer>> threeSumI(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // 从左到右固定一个，然后双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (nums[i] > 0 || nums[k] < 0) {
                break;
            }

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j++]);
                    res.add(nums[k--]);
                    resList.add(res);
                    // 保证元素不重复
                    while (k > j && nums[k] == nums[k+1]) k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            // i 老大也有可能重复
            while (i + 1 < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return resList;
    }


}
