package com.srvivek;

public class LongestPalindromicSubstring {

    String lps = "";

    public int longestPalindromeLength(String s) {
        return longestPlaindrome(s).length();
    }
    public String longestPlaindrome(String s) {

        if(s == null || s.length() <= 1) return s;

        for(int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }

        return lps;
    }

    public void expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if(r - l + 1 > lps.length()) {
            lps = s.substring(l, r + 1);
        }
    }
}
