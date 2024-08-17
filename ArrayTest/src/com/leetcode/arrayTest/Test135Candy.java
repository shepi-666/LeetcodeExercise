package com.leetcode.arrayTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-08-17 08:58
 * @description:
 */
public class Test135Candy {

    /**
     * 作废
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] temp = Arrays.copyOf(ratings, n);
        Arrays.sort(temp);

        // HashMap存储值和相应的坐标
        Map<Integer, List<Integer>> coordinates = new HashMap<>();

        for (int i = 0; i < n; i++) {

        }
        return 0;
    }


    /**
     * [5, 0, 1, 3, 4]
     * 两次遍历，分别从左遍历，如果 i < i + 1, 设为 1，否则设置为 +1
     * [1, 1, 2, 3, 4]
     * 从右边遍历，判断满足右边的规则需要的糖果
     * [2, 1, 1, 1, 1]
     * 最终为这两个的最大值
     * [2, 1, 2, 3, 4]
     * @param ratings
     * @return
     */
    public int candyI(int[] ratings) {
        int n = ratings.length;
        int[] leftRule = new int[n];
        int candy = 0;

        // 遍历满足左规则的时候，需要的最少糖果
        for (int i = 0; i < n; i++) {
            // 当前孩子大于左边孩子，就增加1，否则就只有一颗糖果
            if (i > 0 && ratings[i] - ratings[i - 1] > 0) leftRule[i] = leftRule[i -1] + 1;
            else leftRule[i] = 1;
        }

        int rightRule = 1;
        // 遍历右规则
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) rightRule += 1;
            else rightRule = 1;

            candy += Math.max(leftRule[i], rightRule);
        }

        return candy;
    }
}
