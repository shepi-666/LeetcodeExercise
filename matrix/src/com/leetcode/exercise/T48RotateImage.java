package com.leetcode.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-09-14 17:19
 * @description:
 */
public class T48RotateImage {
    public void rotate(int[][] matrix) {

        int[] border = new int[4];
        border[0] = matrix[0].length-1; // 右边界
        border[1] = matrix.length - 1; // 下边界
        border[2] = 0; // 左边界
        border[3] = 0; // 上边界

        rotateImage(matrix, border);

        System.out.println("=========after===========");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    private void rotateImage(int[][] matrix, int[] border) {
        if (border[0] <= border[2] || border[1] <= border[3]) return;
        int[] newBorder = Arrays.copyOf(border, border.length);
        // 循环读取矩阵到数组中
        List<Integer> temp = new ArrayList<>();
        // 从下往上读取
        for (int i = newBorder[1]; i >= newBorder[3]; i--) {
            temp.add(matrix[i][newBorder[2]]);
        }
        newBorder[2]++;
        // 从左往右去读
        for (int i = newBorder[2]; i <= newBorder[0]; i++) {
            temp.add(matrix[newBorder[3]][i]);
        }
        newBorder[3]++;
        // 从上往下
        for (int i = newBorder[3]; i <= newBorder[1]; i++) {
            temp.add(matrix[i][newBorder[0]]);
        }
        newBorder[0]--;
        // 从右往左
        for (int i = newBorder[0]; i >= newBorder[2]; i--) {
            temp.add(matrix[newBorder[1]][i]);
        }
        newBorder[1]--;

        // 将数字旋转写入到矩阵中
        // 从左往右去读
        int index = 0;
        for (int i = border[2]; i <= border[0]; i++) {
            matrix[border[3]][i] = temp.get(index++);
        }
        border[3]++;
        // 从上往下
        for (int i = border[3]; i <= border[1]; i++) {
            matrix[i][border[0]] = temp.get(index++);

        }
        border[0]--;
        // 从右往左
        for (int i = border[0]; i >= border[2]; i--) {
            matrix[border[1]][i] = temp.get(index++);

        }
        border[1]--;
        for (int i = border[1]; i >= border[3]; i--) {
           matrix[i][border[2]] = temp.get(index++);

        }
        border[2]++;

        // 调用下一层
        rotateImage(matrix, newBorder);

    }

    @Test
    public void testSolution() {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("========origin==============");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        rotateI(matrix);
    }


    /**
     * 1.转置矩阵
     * 2.反转每一行
     * @param matrix
     */
    public void rotateI(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                // 交换matrix[i][j]和matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 对每一行进行反转
        for (int i = 0; i < matrix.length; i++) {
            int l = 0; int r = matrix[i].length - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;

                l++;
                r--;
            }
        }

        System.out.println("=========after===========");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }




}
