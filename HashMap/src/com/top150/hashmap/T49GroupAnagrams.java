package com.top150.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 15:08
 * @description:
 */
public class T49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        Map<String, Integer> codeBook = new HashMap<>();

        for (String str : strs) {
            String compressedCode = getCharCounts(str);
            if (codeBook.containsKey(compressedCode)) {
                int i = codeBook.get(compressedCode);
                resList.get(i).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                resList.add(strList);
                int i = resList.lastIndexOf(strList);
                codeBook.put(compressedCode, i);
            }
        }

        return resList;
    }


    /**
     * 统计单词每个字符出现的词频，并进行压缩返回
     * @param str
     * @return
     */
    private String getCharCounts(String str) {

        int[] array = new int[26]; // 记录词频的数组
        Arrays.fill(array, 0);

        for (char c : str.toCharArray()) {
            array[c - 'a']++;
        }

        // 将词频转换为压缩字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                sb.append(i + 'a').append(array[i]);
            }
        }
        return sb.toString();
    }


    @Test
    public void testSolution() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resList = groupAnagrams(strs);
        for (List<String> group : resList) {
            System.out.println(group.toString());
        }
    }

}
