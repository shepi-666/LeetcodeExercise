package com.leetcode.arrayTest.Test006;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        // 首先确定总共有几行, 每一行作为一个StringBuffer加入入到集合中
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }

        StringBuffer result = new StringBuffer();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();

    }
}
