package com.leetcode.dynamicProgramming.test121;
/* 121. 买卖股票的最佳时机 */

public class MySolution {
    public static void main(String[] args) {
        int[] price = {7, 6, 9, 3, 4};
        System.out.println(maxProfit(price));
    }

    public static int maxProfit(int[] price) {
        int preProfit = 0, profit = 0, maxProfit = 0;
        for (int i = 1; i < price.length; i++) {
            profit = Math.max(0, preProfit + price[i] - price[i - 1]);
            maxProfit = Math.max(maxProfit, profit);
            preProfit = profit;
        }
        return maxProfit;
    }
}
