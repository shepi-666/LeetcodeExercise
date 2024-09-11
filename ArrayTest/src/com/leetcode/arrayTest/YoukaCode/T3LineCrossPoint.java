package com.leetcode.arrayTest.YoukaCode;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author: DongShaowei
 * @create: 2024-09-04 19:34
 * @description:
 */
public class T3LineCrossPoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String pointSet1 = in.nextLine();
        String pointSet2 = in.nextLine();
        /**
         * 求两条直线的焦点，或者平行，重合
         */
        String[] coordinates1 = pointSet1.split(" ");
        String[] coordinates2 = pointSet2.split(" ");

        if (coordinates1.length != 4 || coordinates2.length != 4) {
            System.out.println("error");
            return;
        }
        double[] line1 = new double[4];
        double[] line2 = new double[4];

        for (int i = 0; i < 4; i++) {
            line1[i] = Double.parseDouble(coordinates1[i]);
            line2[i] = Double.parseDouble(coordinates2[i]);
        }

        // 判断垂直x轴的方向
        if (line1[0] - line1[2] == 0 && line2[0] - line2[2] == 0) {
            if (line1[1] == line2[1]) {
                System.out.println("coincide");
            } else {
                System.out.println("parallel");
            }
        }
        double x; double y;

        if (line1[0] - line1[2] == 0 && line2[0] - line2[2] != 0) {
            // line1为垂直
            double k2 = (line2[1] - line2[3]) / (line2[0] - line2[2]);
            double b2 = line2[1] - k2 * line2[0];
            x = line1[0];
            y = k2 * x + b2;
            System.out.println(String.format("%.2f", x) + "," + String.format("%.2f", y));
            return;
        }

        if (line1[0] - line1[2] != 0 && line2[0] - line2[2] == 0) {
            // line1为垂直
            double k1 = (line1[1] - line1[3]) / (line1[0] - line1[2]);
            double b1 = line1[1] - k1 * line1[0];
            x = line1[0];
            y = k1 * x + b1;
            System.out.println(String.format("%.2f", x) + "," + String.format("%.2f", y));
            return;
        }



        // 斜率相同的情况
        double k1 = (line1[1] - line1[3]) / (line1[0] - line1[2]);
        double k2 = (line2[1] - line2[3]) / (line2[0] - line2[2]);

        // 判断截距是否相同
        double b1 = line1[1] - k1 * line1[0];
        double b2 = line2[1] - k2 * line2[0];

        if (k1 == k2) {
            if (b1 == b2) {
                System.out.println("coincide");
            } else {
                System.out.println("parallel");
            }
            return;
        }

        // 说明相交了
        x = (b2 - b1) / (k1 - k2);
        y = k1 * x + b1;
        System.out.println(String.format("%.2f", x) + "," + String.format("%.2f", y));

    }

}
