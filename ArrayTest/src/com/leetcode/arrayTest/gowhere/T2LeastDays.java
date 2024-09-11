package com.leetcode.arrayTest.gowhere;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-06 15:56
 * @description:
 */
public class T2LeastDays {

    /**
     * 输入
     * 5 20 任务数量 | 目标分数
     * 1 2 3 4 5 成长值 （递增？
     * 4 2 3 5 10 翻倍卡
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] row1 = in.nextLine().split(" ");
        String[] row2 = in.nextLine().split(" ");
        String[] row3 = in.nextLine().split(" ");

        int days = Integer.parseInt(row1[0]);
        long target = Long.parseLong(row1[1]);
        int[] points = new int[days];
        int[] cards = new int[days];
        for (int i = 0; i < days; i++) {
            points[i] = Integer.parseInt(row2[i]);
            cards[i] = Integer.parseInt(row3[i]);
        }


        List<Integer> curPoints = new ArrayList<>(days);
        List<Integer> curCards = new ArrayList<>(days);
        List<Long> maxPoints = new ArrayList<>(days);

        for (int i = 0; i < days; i++) {
            curPoints.add(points[i]);
            curCards.add(cards[i]);
            long maxPoint = 0;
            curPoints.sort(Comparator.comparingInt(o -> o));
            curCards.sort(Comparator.comparingInt(o -> o));
            for (int j = 0; j <= i; j++) {
                maxPoint += (long) curPoints.get(j) * curCards.get(j);
            }
            // 存入到List
            maxPoints.add(maxPoint);
        }

        int i = 0;
        while (i < days) {
            if (maxPoints.get(i) >= target) {
                System.out.println(i + 1);
                return;
            }
            i++;
        }
        System.out.println("-1");

    }
}
