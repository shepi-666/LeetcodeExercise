package com.top150.ranges;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-20 16:07
 * @description: 合并区间
 */
public class T56MergeRanges {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> tempList = new ArrayList<>();

        if (intervals.length <= 1) return intervals;

        for (int[] interval : intervals) {
            mergeInterval(interval, tempList);
        }

        int[][] res = new int[tempList.size()][2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = tempList.get(i).get(j);
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
        return res;
    }

    /**
     * 将当前区间和区间列表中的区间进行合并
     * @param interval
     * @param tempList
     */
    private void mergeInterval(int[] interval, List<List<Integer>> tempList) {

        // 当前区间无法和区间列表合并
        List<Integer> newInterval = new ArrayList<Integer>();
        int lIndex = interval[0];
        int rIndex = interval[1];

        Iterator<List<Integer>> iterator = tempList.iterator();
        while (iterator.hasNext()){
            List<Integer> tempInterval = iterator.next();
            // 可以合并区间的情况
            // 右A >= 左B && 左A <= 右B
            int leftA = lIndex;
            int rightA = rIndex; // 碰撞之后的指针
            int leftB = tempInterval.get(0);
            int rightB = tempInterval.get(1);
            if (rightA >= leftB && leftA <= rightB || rightB >= leftA && leftB <= rightA) {
                lIndex = Math.min(leftA, leftB);
                rIndex = Math.max(rightA, rightB);
                iterator.remove();
            }
        }
        newInterval.add(lIndex);
        newInterval.add(rIndex);


        tempList.add(newInterval);
    }

    @Test
    public void testSolution() {
        int[][] intervals = {
                {2,3},{4,6},{5,7},{3,4}
        };
        merge(intervals);
    }
    public int[][] mergeI(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 按照左端点排序
            }
        });

        int count = 0; // 表示合并后区间的数量
        int[] pre = intervals[0]; // 假定为标定区间，用于比较
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= pre[1]) {
                // 可以进行区间合并，确定右端点，左端点已经确定
                int r = Math.max(cur[1], pre[1]);
                pre = new int[]{pre[0], r};
            } else {
                // 不能合并，将合并区间放入到原数组count 位置
                intervals[count++] = pre;
                pre = cur;
            }
        }

        // 将最后合并的区间记录下来
        intervals[count++] = pre;

        return Arrays.copyOfRange(intervals, 0, count);

    }
}
