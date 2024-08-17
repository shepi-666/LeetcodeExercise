package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-08-16 09:00
 * @description:
 */
public class Test274HIndex {
    public int hIndex(int[] citations) {
        // 先排序
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        int l = 0;
        while ((l < n)) {
            // 高引用文章数量大于当前引用数量
            if (n - l >= citations[l]) h = citations[l];
            else {
                // 高引用文章数量大于当前指数
                while (n - l > h) h++;
            }
            l++;
        }
        return h;
    }

    @Test
    public void test() {
        int[] nums = {11, 15, 100};
        System.out.println(hIndex(nums));

    }
}
