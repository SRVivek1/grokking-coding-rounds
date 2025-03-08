package com.srvivek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicStringTest {

    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    @Test
    void singleCharacterString() {
        assertEquals("a", lps.longestPlaindrome("a"));
    }

    @Test
    void twoCharacterPalindrome() {
        assertEquals("aa", lps.longestPlaindrome("aa"));
    }

    @Test
    void twoCharacterNonPalindrome() {
        assertEquals("a", lps.longestPlaindrome("ab"));
    }

    @Test
    void simplePalindrome() {
        assertEquals("aba", lps.longestPlaindrome("aba"));
    }

    @Test
    void longerPalindrome() {
        assertEquals("racecar", lps.longestPlaindrome("racecar"));
    }

    @Test
    void palindromeInMiddle() {
        assertEquals("bacdcab", lps.longestPlaindrome("abacdcab"));
    }

    @Test
    void noPalindrome() {
        assertEquals("a", lps.longestPlaindrome("abcdefg"));
    }

    @Test
    void emptyString() {
        assertEquals("", lps.longestPlaindrome(""));
    }

    @Test
    void nullString() {
        assertNull(lps.longestPlaindrome(null));
    }

    @Test
    void longestPalindromeLength() {
        assertEquals(7, lps.longestPalindromeLength("racecar"));
    }
}