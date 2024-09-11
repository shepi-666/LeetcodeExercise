package com.leetcode.arrayTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-08-26 08:23
 * @description:
 */
public class T68TextAlign {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();

        int len = 0;
        List<String> rowWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() <= maxWidth) {
                rowWords.add(words[i] + " ");
                len += words[i].length() + 1; // 每个单词要加一个空格
            } else {
                String rowString = getRowString(len, rowWords, maxWidth, false);
                res.add(rowString);
                len = 0;
                rowWords.clear();
                i--;
            }
        }
        // 对最后一行的处理
        res.add(getRowString(len, rowWords, maxWidth, true));
        return res;
    }


    public String getRowString(int len, List<String> rowWords, int maxWidth, boolean last) {
        // 此时单词应当是 This |is |an |
        len -= 1; // 用掉的长度为这么多
        int gaps = rowWords.size() - 1 == 0 ? 1 : rowWords.size() - 1; // 间隙
        int remainBlanks = maxWidth - len;
        StringBuilder blank = new StringBuilder();
        if (last) {
            // 最后一行左对齐
            for (int i = 0; i < remainBlanks; i++) {
                blank.append(" ");
            }
            rowWords.set(rowWords.size()-1, rowWords.get(rowWords.size()-1) + blank);
        } else {
            int blanks = remainBlanks / gaps; // 平均每个间隙插的空格数

            for (int j = 0; j < blanks; j++) {
                blank.append(" ");
            }
            int remainders = remainBlanks % gaps; // 剩多少个空格
            for (int j = 0; j < remainders; j++) {
                rowWords.set(j, rowWords.get(j) + " "); // 多出来的空格添加到左边
            }
            // 给每个单词添加空格
            for (int j = 0; j < gaps; j++) {
                rowWords.set(j, rowWords.get(j) + blank.toString());
            }
        }

        // 将单词拼接起来
        StringBuilder wordText = new StringBuilder();
        for (String word : rowWords) {
            wordText.append(word);
        }
        return wordText.substring(0, wordText.length() - 1);
    }


    @Test
    public void testSolution() {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        fullJustify(words, 16).forEach(System.out::println);
    }

}
