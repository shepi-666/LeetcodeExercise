package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-15 09:46
 * @description:
 */
public class Test121MaxProfit {
    /**
     * 超时
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    @Test
    public void test(){
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfitII(nums));
    }

    /**
     * 失败
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) return 0;
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            pre = pre + prices[i] - prices[i-1];
            maxProfit = Math.max(maxProfit, pre);
        }
        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        // 遍历得到局部最小点
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // 当前卖出能得多少
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
