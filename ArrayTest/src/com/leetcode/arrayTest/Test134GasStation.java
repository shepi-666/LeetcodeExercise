package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-16 11:05
 * @description:
 */
public class Test134GasStation {
    /**
     * 超时
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int[] remainders = new int[n];
        int total = 0;

        // 统计每个站到下一站的盈余
        for (int i = 0; i < n; i++) {
            remainders[i] = gas[i] - cost[i];
            total = total + remainders[i];
        }
        if (total < 0) return -1;
        int i = 0;

        // 遍历循环每个站的耗费
        while (i < n) {
            while (remainders[i] < 0) i++;
            total = 0;
            for (int j = i; j < n; j++) {
                total = remainders[j] + total;
                if (total < 0) break;
            }
            if (total > 0) {
                for (int j = 0; j < i; j++) {
                    total = remainders[j] + total;
                    if (total < 0) break;;
                }
            }
            if (total >= 0) return i;
            else i++;
        }
        return -1;

    }




    @Test
    public void test() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }


    /**
     * 若 x 无法到达 y+1，则 x~y 之间的所有值都无法到达 y+1, y+1 是离 x 最近的无法到达点
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitII(int[] gas, int[] cost) {

        int n = gas.length;
        int i = 0;
        // 遍历循环每个站的耗费
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int j = 0;// 从当前位置循环一周
            while (j < n) {
                int k = (i+j) % n;
                sumOfCost += cost[k];
                sumOfGas += gas[k];
                if (sumOfGas < sumOfCost) break;
                j++;
            }
            if (j == n) return i; // 表示正好循环了一周
            else {
                i = i + j + 1; // 能达到的最远位置+1
            }
        }
        return -1;
                                                                                                                                                                                                                                                                }
}
