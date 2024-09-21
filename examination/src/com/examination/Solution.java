package com.examination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 19:40
 * @description:
 */
public class Solution {
    public List<String> test(double length, double width, double height, double weight) {

        // 单位转换常数
        double cmToInches = 2.54;
        double kgToPounds = 0.454;

        // 输入参数转换为英制单位
        int lengthIn = (int) Math.ceil(length / cmToInches);
        int widthIn = (int) Math.ceil(width / cmToInches);
        int heightIn = (int) Math.ceil(height / cmToInches);
        int weightLb = (int) Math.ceil(weight / kgToPounds);


        int[] dimensions = {lengthIn, widthIn, heightIn};
        Arrays.sort(dimensions);

        // 按照大小取出边
        int longest = dimensions[2];
        int secondLongest = dimensions[1];
        int thirdLongest = dimensions[0];

        // 计算围长
        int girth = longest + 2 * (secondLongest + thirdLongest);

        // 计算体积重
        int volumeWeight = (int) Math.ceil((double) (longest * secondLongest * thirdLongest) / 250);

        // 实际重量
        int actualWeight = Math.max(weightLb, volumeWeight);

        List<String> output = new ArrayList<>();


        // 条件判断
        if (actualWeight > 150 || longest > 108 || girth > 165) {
            output.add("OUT_SPACE");
            return output;
        }

        if ((girth > 130 && girth <= 165) || (longest >= 96 && longest <= 108)) {
            output.add("OVERSIZE");
            return output; // No need to check AHS
        }

        if (actualWeight > 50 && actualWeight <= 150) {
            output.add("AHS-WEIGHT");
        }

        if (girth > 105 || (longest >= 48 && longest < 108) || secondLongest >= 30) {
            output.add("AHS-SIZE");
        }

        return output;
    }

    @Test
    public void testSolution() {
        double length = 114.50;
        double width = 42;
        double height = 26;
        double weight = 47.5;
        System.out.println(test(length, width, height, weight));
    }

}
