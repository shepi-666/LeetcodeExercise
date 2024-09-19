package com.top150.hashmap;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 16:19
 * @description:
 */
public class T202HappyNum {

    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (true) {
            n = squareSum(n);
            if (n == 1) return true;
            else {
                if (sumSet.contains(n)) return false;
                else sumSet.add(n);
            }
        }
    }

    private int squareSum(int n) {
        int res = 0;
        String numStr = String.valueOf(n);
        for (char c : numStr.toCharArray()) {
            res += Math.pow(c - '0', 2.0);
        }
        return res;
    }

    @Test
    public void testSolution() {
        int n = 2;
        System.out.println(isHappy(n));
    }

    /**
     * 使用快慢指针实现
     * @param n
     * @return
     */
    public boolean isHappyI(int n) {
        int slow = squareSum(n);
        int fast = squareSum(slow);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        return slow == 1;
    }
}
