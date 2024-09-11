package com.leetcode.arrayTest.tencent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-05 19:06
 * @description:
 */
public class T1Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型ArrayList
     * @return int整型ArrayList
     */
    public ArrayList<Integer> newArray (ArrayList<Integer> a) {
        // write code here

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer e : a) {
            String trimNum = e.toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < trimNum.length(); i++) {
                if (trimNum.charAt(i) != '2') {
                    sb.append(trimNum.charAt(i));
                }
            }
            if (!sb.toString().equals("")) {
                res.add(Integer.parseInt(sb.toString()));
            }
        }
        return res;
    }
    @Test
    public void testSolution() {

        ArrayList<Integer> nums = new ArrayList();
        nums.add(5);
        nums.add(12);
        nums.add(20);
        nums.add(2);
        nums.add(77);
        System.out.println(newArray(nums).toString());
    }
}
