package com.leetcode.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-09-18 15:28
 * @description:
 */
public class T289GameOfLife {


    /**
     * 1.定义一个统计周围活细胞的方法
     * 2.根据条件确定该细胞是否存活
     * @param board
     */
    public void gameOfLife(int[][] board) {

        int[][] aliveCells = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 当前细胞死活
                int counts = countAliveCells(i, j, board);
                if (board[i][j] == 1) {
                    if (counts < 2) {
                        aliveCells[i][j] = 0;
                    } else if (counts <= 3) {
                        aliveCells[i][j] = 1;
                    } else {
                        aliveCells[i][j] = 0;
                    }
                } else {
                    // 当前细胞死了
                    if (counts == 3) {
                        aliveCells[i][j] = 1;
                    } else {
                        aliveCells[i][j] = 0;
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = aliveCells[i][j];
            }
        }


        System.out.println("===========next status============");
        for (int[] rows : aliveCells) {
            System.out.println(Arrays.toString(rows));;
        }

    }

    private int countAliveCells(int i, int j, int[][] board) {
        int beginRow = Math.max(i - 1, 0);
        int endRow = Math.min(i + 1, board.length - 1);
        int beginCol = Math.max(j - 1, 0);
        int endCol = Math.min(j + 1, board[0].length - 1);

        int count = 0;
        for (int k = beginRow; k <= endRow; k++) {
            for (int l = beginCol; l <= endCol; l++) {
                if (board[k][l] == 1 && (k != i || l != j)) {
                    count++;
                }
            }
        }

        return count;
    }


    @Test
    public void testSolution() {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        System.out.println("==========original matrix============");
        for (int[] rows : board) {
            System.out.println(Arrays.toString(rows));
        }

        gameOfLife(board);
    }


    public void gameOfLifeI(int[][] board) {

        int[][] aliveCells = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 当前细胞死活
                int counts = countAliveCells(i, j, board);
                if (board[i][j] == 1) {
                    if (counts < 2) {
                        aliveCells[i][j] = 0;
                    } else if (counts <= 3) {
                        aliveCells[i][j] = 1;
                    } else {
                        aliveCells[i][j] = 0;
                    }
                } else {
                    // 当前细胞死了
                    if (counts == 3) {
                        aliveCells[i][j] = 1;
                    } else {
                        aliveCells[i][j] = 0;
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = aliveCells[i][j];
            }
        }


        System.out.println("===========next status============");
        for (int[] rows : aliveCells) {
            System.out.println(Arrays.toString(rows));;
        }

    }


}
