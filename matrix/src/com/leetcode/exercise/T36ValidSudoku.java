package com.leetcode.exercise;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-09-14 15:21
 * @description: 有效的数独
 */
public class T36ValidSudoku {

    /**
     * 每行每列
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 首先判断每行是否符合
        for (int i = 0; i < board.length; i++) {
            int[] isVisited = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (isVisited[board[i][j]- '0']  != 1) {
                        isVisited[board[i][j]- '0'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        // 判断每列是否符合
        for (int i = 0; i < board[0].length; i++) {
            int[] isVisited = new int[10];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (isVisited[board[j][i] - '0'] != 1) {
                        isVisited[board[j][i] - '0'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        // 判断每个小方格是否符合
        for (int i = 2; i < board.length; i += 3) {
            for (int j = 2; j < board[0].length; j += 3) {
                int[] isVisited = new int[10];
                for (int k = i - 2; k <= i; k++) {
                    for (int l = j - 2; l <= j; l++) {
                        if (board[k][l] != '.') {
                            if (isVisited[board[k][l] - '0'] != 1) {
                                isVisited[board[k][l] - '0'] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    @Test
    public void testSolution() {
        char[][] board = {  {'.','.','4','.','.','.','6','3','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'5','.','.','.','.','.','.','9','.'},
                            {'.','.','.','5','6','.','.','.','.'},
                            {'4','.','3','.','.','.','.','.','1'},
                            {'.','.','.','7','.','.','.','.','.'},
                            {'.','.','.','5','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }

}
