package com.srvivek;

import java.util.HashMap;
import java.util.Map;

public class AnagramString {

    public boolean isAnagram(String s1, String s2, boolean ignoreCase) {
        if(ignoreCase) {
            s1= s1.toLowerCase();
            s2= s2.toLowerCase();
        }
        return isAnagram(s1, s2);
    }

    public boolean isAnagram(String s1, String s2) {

        // same length check
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;

        // create map
        final Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // check if all characters in s2 are present in map
        for(char c: s2.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) {
                return false;
            } else if (count > 1) {
                map.put(c, count - 1);
            } else {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
}