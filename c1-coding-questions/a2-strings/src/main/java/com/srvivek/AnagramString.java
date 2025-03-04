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


    }
}