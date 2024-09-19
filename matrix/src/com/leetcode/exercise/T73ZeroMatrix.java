package com.leetcode.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: DongShaowei
 * @create: 2024-09-18 15:02
 * @description:
 */
public class T73ZeroMatrix {

    /**
     * 实现思路：先遍历一遍，将行和列分别存储在两个set中
     * 再遍历一遍，如果当前坐标在set中，就置为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        // 将 0 元素的行列存储到对应的 set 中
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        // set 中的行或者列都置为 0
        for (int i = 0; i < matrix.length; i++) {
            if (rowSet.contains(i)) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            } else {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (colSet.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }


        System.out.println("=========transformed matrix==========");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


    @Test
    public void testSolution() {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        System.out.println("======original matrix=======");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

        setZeroes(matrix);
    }

}
