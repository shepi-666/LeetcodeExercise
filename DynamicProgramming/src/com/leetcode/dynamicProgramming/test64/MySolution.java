package com.leetcode.dynamicProgramming.test64;
/* 64. 最短路径和 */
public class MySolution {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
        };
        System.out.println(minPathSum(grid));
    }
    // 为了减小使用的内存，我们直接在原数组中进行修改
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 对这个dp表的第一行和第一列赋值
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        // 使用状态转移方程对dp表进行填充
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j],  grid[i][j - 1]);
            }
        }
        return grid[m-1][n-1];
    }
}
