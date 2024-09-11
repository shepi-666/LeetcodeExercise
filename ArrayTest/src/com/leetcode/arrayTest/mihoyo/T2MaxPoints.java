package com.leetcode.arrayTest.mihoyo;

import java.util.*;


/**
 * @author: DongShaowei
 * @create: 2024-09-07 16:56
 * @description:
 */
public class T2MaxPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        String curLine = null;
        while (!(curLine = in.nextLine()).isEmpty()) { // 注意 while 处理多个 case
            inputs.add(curLine);
        }
        in.close();
        int numStages = Integer.parseInt(inputs.get(0).split(" ")[0]);
        int numLegends = Integer.parseInt(inputs.get(0).split(" ")[1]);
        int[] counts = new int[numLegends];
        Arrays.fill(counts, 0);

        long[] extraPower = new long[numLegends];
        String[] extraStr = inputs.get(1).split(" ");
        for (int i = 0; i < numLegends; i++) {
            extraPower[i] = Long.parseLong(extraStr[i]);
        }

        // 能够全收集的英雄
        List<Integer> fullCollection = new ArrayList<>();

        // 英雄和能力用kv方式存储到treemap中
        List<TreeMap<Integer, Long>> stageReward = new ArrayList<>(numStages);

        long maxPoints = 0;

        long[] maxPowers = new long[numStages];
        int index = 0;

        for (int i = 2; i < inputs.size(); i++) {
            TreeMap<Integer, Long> rewards = new TreeMap<>();
            String[] power = inputs.get(i).split(" ");
            String[] legends = inputs.get(++i).split(" ");
            // 每一关有三个奖励
            long maxPow = 0;
            for (int j = 0; j < 3; j++) {
                maxPow = Math.max(maxPow, Long.parseLong(power[j])); // 每一关的最大值
                counts[Integer.parseInt(legends[j])-1] ++;
                if (counts[Integer.parseInt(legends[j])-1] >= 3) {
                    fullCollection.add(Integer.parseInt(legends[j])-1); // 第几位英雄全收集了
                }
                rewards.put(Integer.parseInt(legends[j]), Long.parseLong(power[j]));
            }
            stageReward.add(rewards);
            maxPoints += maxPow;
            maxPowers[index++] = maxPow; // 记录每一关的最大值
        }


        /**
         想一想：
         1.总共4管，看看哪个可以获取额外能力的英雄有几个
         2.对这些可以获得额外能力的英雄排序，从大到小
         3.选择你的英雄
         3.1 每轮都选最大的
         3.2 每轮都选择可以全收集的英雄
         4.最大的一定就是最高分的
         */

        for (int i = 0; i < fullCollection.size(); i++) { // 全收集的英雄
            int curLegend = fullCollection.get(i);
            long legendPoints = extraPower[curLegend];
            for (int j = 0; j < numStages; j++) {
                // 每个stage选择该英雄
                TreeMap<Integer, Long> curRewards = stageReward.get(i);
                // 要么已经有的，要么最大的
                legendPoints += curRewards.containsKey(curLegend + 1) ? curRewards.get(curLegend) : maxPowers[j];
            }
            maxPoints = Math.max(maxPoints, legendPoints);
        }

        System.out.println(maxPoints);

    }
}
