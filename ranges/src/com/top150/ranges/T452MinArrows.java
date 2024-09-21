package com.top150.ranges;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 14:42
 * @description: 用最少的箭引爆气球
 */
public class T452MinArrows {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;

        int count = 0; // 计算需要的键数
        // 先将气球排序好
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int[] pre = points[0];
        for (int i = 1; i < points.length; i++) {
            // 如果没有产生碰撞，需要一支箭
            int[] cur = points[i];
            if (pre[1] < cur[0]) {
                count++;
                pre = cur;
            } else {
                // 产生碰撞，计算碰撞区间
                int l = cur[0];
                int r = Math.min(cur[1], pre[1]);
                // 将相交区间赋值给pre
                pre = new int[]{l, r};
            }
        }
        // 最后一支箭 pre
        count++;
        return count;
    }


    @Test
    public void testSolution() {
        int[][] points = {
                {3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}
        };
        System.out.println(findMinArrowShots(points));
    }


}
