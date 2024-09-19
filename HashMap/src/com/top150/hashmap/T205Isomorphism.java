package com.top150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-09-18 16:57
 * @description:
 */
public class T205Isomorphism {
    /**
     * 分别将 s对t的映射和t对s的映射存储到两个Map中
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (s2t.containsKey(x) && s2t.get(x) != y || t2s.containsKey(y) && t2s.get(y) != x) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

}
