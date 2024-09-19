package com.top150.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 15:49
 * @description:
 */
public class TwoSum {

    /**
     * map存放和target - nums[i]匹配失败的数字
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 如果出现重复的数字，那么只会重复一次，并且答案就是重复的两个数字
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return  res;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
