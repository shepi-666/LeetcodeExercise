package com.top150.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 16:55
 * @description: 存在重复元素
 */
public class T219NearByDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);

        }
        return false;
    }


    @Test
    public void testSolution() {
        int[] nums= {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

}
