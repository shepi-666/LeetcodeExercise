package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-08-15 08:04
 * @description:
 */
public class Test169MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        int max = nums.length >> 2;
        int retVal = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                retVal = entry.getKey();
            }
        }

        return retVal;


    }

    @Test
    public void test() {
        int[] nums = {3,2,3};
        System.out.println(majorityElementIII(nums));
    }


    /**
     * 先排序，再取中间值；因为众数的中间值肯定为二分之一的位置
     * @param nums
     * @return
     */
    public int majorityElementII(int[] nums)  {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票算法：
     * 维护一个候选人Candidate 和 次数 count
     * 次数为 0 就更换count
     * @param nums
     * @return
     */
    public int majorityElementIII(int[] nums) {

        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) candidate = nums[i];
            else count += (nums[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
