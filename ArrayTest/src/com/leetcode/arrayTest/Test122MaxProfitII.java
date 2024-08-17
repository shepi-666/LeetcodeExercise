package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-15 10:15
 * @description:
 */
public class Test122MaxProfitII {

    /**
     * 使用双指针判断单调性，快指针在局部最大值，慢指针在局部最小值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int slow = 0, fast = 1;
        if (prices.length <= 1) return 0;
        while (fast < prices.length) {
            while ((fast < prices.length) &&(prices[fast] - prices[fast - 1] >= 0)) {
                fast++;
            }
            maxProfit = maxProfit + prices[fast - 1] - prices[slow];
            while ((fast < prices.length) && (prices[fast] - prices[fast - 1]) < 0) fast++;
            slow = fast - 1;
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));

    }
}
