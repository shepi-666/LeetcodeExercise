package com.top150.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-19 14:38
 * @description:
 */
public class T290WordPattern {

    /**
     * 将字符串拆分为数组
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != array.length) return false;
        Map<Character, String> c2s =  new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (c2s.containsKey(chars[i]) && !c2s.get(chars[i]).equals(array[i]) ||
                    s2c.containsKey(array[i]) && !s2c.get(array[i]).equals(chars[i])) {
                return false;
            }
            c2s.put(chars[i], array[i]);
            s2c.put(array[i], chars[i]);
        }
        return true;

    }


    @Test
    public void testSolution() {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
