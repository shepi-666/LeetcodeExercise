package com.leetcode.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-14 16:14
 * @description:
 */
public class T54SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {


        // 0 左 1 下 2 右 3 上
        int direction = 0;
        List<Integer> res = new ArrayList<>();
        // 边界
        int[] border = new int[4];
        border[0] = matrix[0].length-1; // 右边界
        border[1] = matrix.length-1; // 下边界
        border[2] = 0; // 上边界
        border[3] = 0; // 左边界

        rotateMatrix(matrix, direction, res, border);
        return res;
    }

    private void rotateMatrix(int[][] matrix, int direction, List<Integer> res, int[] border) {
        if (res.size() == matrix.length * matrix[0].length) return;
        switch (direction) {
            case 0:
                // 从左到右,固定上边界，上边界减1
                for (int k = border[3]; k <= border[0]; k++) {
                    res.add(matrix[border[2]][k]);
                }
                // 上边界加1
                border[2]++;
                // 向下打印
                rotateMatrix(matrix, 1, res, border);
                break;
            case 1:
                // 从上到下,右边界固定，右边界减1
                for (int k = border[2]; k <= border[1]; k++) {
                    res.add(matrix[k][border[0]]);
                }
                border[0]--;
                // 向左打印
                rotateMatrix(matrix, 2, res, border);
                break;
            case 2:
                // 从右往左打印，固定下边界，下边界减1
                for (int i = border[0]; i >= border[3]; i--) {
                    res.add(matrix[border[1]][i]);
                }
                border[1]--;
                rotateMatrix(matrix, 3, res, border);
                break;
            case 3:
                for (int i = border[1]; i >= border[2]; i--) {
                    res.add(matrix[i][border[3]]);
                }
                border[3]++;
                rotateMatrix(matrix, 0, res, border);
        }

    }
    @Test
    public void testSolution() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix).toString());
    }

}
