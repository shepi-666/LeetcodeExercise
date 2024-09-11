package com.leetcode.arrayTest.sf;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-07 20:30
 * @description:
 */
public class T2GoFarest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = Integer.parseInt(sc.nextLine());
        int lines = groups * 3;
        List<String> inputs = new ArrayList<>(lines) ;
        for (int i = 0; i < lines; i++) {
            inputs.add(sc.nextLine());
        }

        for (int i = 0; i < groups; i++) {
            String[] baseInfoStr = inputs.get(i * 3).split(" ");

            // 同一个位置有多个增强？
            String[] powerPositionStr = inputs.get(i * 3 + 1).split(" ");
            String[] powerStr = inputs.get(i * 3 + 2).split(" ");

            Map<Integer, Integer> powerBin = new LinkedHashMap<>();


            int stepSize = Integer.parseInt(baseInfoStr[0]);
            int days = Integer.parseInt(baseInfoStr[1]);
            int powerCounts = Integer.parseInt(baseInfoStr[2]);


            // 字符串转为整数
            for (int j = 0; j < powerCounts; j++) {
                int position = Integer.parseInt(powerPositionStr[j]);
                int power = Integer.parseInt(powerStr[j]);
                if (!powerBin.containsKey(position)) {
                    powerBin.put(position, power);
                } else {
                    if (powerBin.get(position) < power) {
                        powerBin.put(position, power);
                    }
                }
            }
            int[] powerPositions = new int[powerBin.size()];
            int[] powers = new int[powerBin.size()];
            int count = 0;
            for (Map.Entry<Integer, Integer> bin : powerBin.entrySet()) {
                powerPositions[count] = bin.getKey();
                powers[count] = bin.getValue();
                count++;
            }

            // 调用方法
            System.out.println(getDistance(stepSize, days, powerPositions, powers));

        }
    }


    /**
     * 一个位置可能有多个增强
     * @param stepSize
     * @param days
     * @param powerPosition
     * @param power
     * @return
     */
    public static int getDistance(int stepSize, int days, int[] powerPosition, int[] power) {
        int farDistance = stepSize * days;
        int powered = 0; // 表示增强次数
        int curDistance = 0; // 表示已经走过的路
        while (days > 0) {
            int todayPosition = curDistance + stepSize; // 今天最远的路

            // 能够获得增强并且能够到达增强的地方
            if (powered < power.length && todayPosition >= powerPosition[powered]) {
                // 获得增强之后理想最远距离
                int poweredDistance = powerPosition[powered] + (days - 1) * (stepSize + power[powered]);
                if (poweredDistance > farDistance) {
                    farDistance = poweredDistance; // 理想最远的距离变大
                    // 增强操作
                    curDistance = powerPosition[powered]; // 位置前进
                    stepSize += power[powered]; // 步长增大
                    powered++;

                }
            } else {
                curDistance = todayPosition;
            }

            // 日子变更
            days--;
        }
        return farDistance;
    }

    @Test
    public void testGetDistance() {

        int stepSize = 1;
        int days = 0;
        int[] powerPosition = {1};
        int[] power = {1};
        System.out.println(getDistance(stepSize, days, powerPosition, power));

    }
}
