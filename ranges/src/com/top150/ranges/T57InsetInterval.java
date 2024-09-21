package com.top150.ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-20 17:43
 * @description: 插入区间
 */
public class T57InsetInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] totalIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        totalIntervals[totalIntervals.length - 1] = newInterval;

        // 排序
        Arrays.sort(totalIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] pre = totalIntervals[0];
        int count = 0;
        for (int i = 1; i < totalIntervals.length; i++) {
            int[] cur = totalIntervals[i];
            if (cur[0] <= pre[1]) {
                int r = Math.max(cur[1], pre[1]);
                pre = new int[]{pre[0], r};
            } else {
                totalIntervals[count++] = pre;
                pre = cur;
            }
        }
        totalIntervals[count++] = pre;
        return Arrays.copyOfRange(totalIntervals, 0, count);
    }


    public int[][] insertI(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(); // 结果集
        // 记录插入区间的左右坐标
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false; // 是否插入的标记
        for(int[] interval:intervals){ // 遍历每个区间
            if(interval[0] > right){
                // 当前区间在目标区间的右侧，并且没有插入，说明新区间和所有的都没有交集，直接放入
                if(!placed){
                    list.add(new int[]{left,right}); // 放入插入区间
                    placed=true;
                }
                list.add(interval); // 放入当前区间
            }else if(interval[1] < left){ // 当前区间在目标区间的左侧
                list.add(interval); // 放入当前区间
            }else{
                // 有重合的情况，记录碰撞之后的区间
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!placed){ // 没有放入
            list.add(new int[]{left,right});
        }

        // 将列表转换为数组
        int[][] ans = new int[list.size()][];
        for(int k = 0; k<list.size();k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}
