package com.leetcode.arrayTest;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-08-25 08:53
 * @description:
 */
public class T0006ZConvertion {

    /**
     * 0 rows+rows-2(2rows-2) 4rows-4 6rows-6
     * 1 2rows-3
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int elements = (2*numRows-2); // 一个V字的元素数
        int batch = s.length() / elements; // 有几组完整的V字
        int remainders = s.length() % elements; // 计算有多少列
        int col = batch * (numRows - 1);
        col += remainders <= numRows ? 1 : remainders - numRows + 1;

        char[][] map = new char[numRows][col];
        int v = 0; int h = 0;
        for (int i = 0; i < s.length(); i++) {
            map[v][h] = s.charAt(i);
            if ((i+1) % elements < numRows && (i+1) % elements != 0) { // 垂直指针往下走，水平不动
                v++;
            } else { // 垂直指针往上走，水平往右边走
                v--;
                h++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0) {
                    builder.append(map[i][j]);
                }
            }
        }
        return  builder.toString();

    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,4));
    }

}
