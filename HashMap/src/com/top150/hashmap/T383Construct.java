package com.top150.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-18 16:23
 * @description:
 */
public class T383Construct {


    /**
     * 将 magazine中的字符和出现频次统计在HashMap中
     * 遍历 ransomNote，如果出现，就减1
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        // 将magazine中的字符统计在HashMap
        for (char c : magazine.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (!charMap.containsKey(c)) {
                return false;
            } else {
                int counts = charMap.get(c);
                if (counts == 1) {
                    charMap.remove(c, counts);
                } else {
                    charMap.put(c, counts - 1);
                }
            }
        }
        return true;
    }


    @Test
    public void testSolution() {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

}
