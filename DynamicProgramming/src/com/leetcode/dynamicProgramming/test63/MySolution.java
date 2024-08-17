package com.leetcode.dynamicProgramming.test63;
/* 63 不同路径Ⅱ */
public class MySolution {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0},
        };
        System.out.println(uniquePaths(obstacleGrid));
    }
    public static int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 首先应当建立一个dp数组
        int[][] dp = new int[m][n];
        // 先对第一行和第一列进行初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        // 然后我们就可以使用dp了
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
