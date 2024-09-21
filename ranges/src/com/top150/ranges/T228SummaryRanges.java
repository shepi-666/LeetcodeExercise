package com.top150.ranges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-20 15:25
 * @description:
 */
public class T228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int i = 0; int j = 1;
        while (true) {
            while (j < nums.length && nums[j] - nums[j - 1] == 1) j++;
            // 此时 j 处于下一个的左端点，i 处于上一个的左端点
            if (i == j - 1) {
                res.add(String.valueOf(nums[i]));
            } else {
                // 将区间放入到res中
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]).append("->").append(nums[j - 1]);
                res.add(sb.toString());
            }
            if (j == nums.length) break;
            // i跳到下一个区间的左端点，j右移一位
            i = j++;
        }


        return res;

    }


    @Test
    public void testSolution() {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums).toString());
    }
}
