package com.srvivek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramStringTest {

    AnagramString anagramString = null;

    @BeforeEach
    public void setUp() {
        anagramString = new AnagramString();
    }

    @Test
    void nullStrings() {
        assertFalse(anagramString.isAnagram(null, "abc", false));
        assertFalse(anagramString.isAnagram("abc", null, false));
        assertFalse(anagramString.isAnagram(null, null, false));
    }

    @Test
    void anagramWithIgnoreCase() {
        assertTrue(anagramString.isAnagram("Listen", "Silent", true));
    }

    @Test
    void anagramWithoutIgnoreCase() {
        assertTrue(anagramString.isAnagram("listen", "silent", false));
    }

    @Test
    void notAnagramWithIgnoreCase() {
        assertFalse(anagramString.isAnagram("Hello", "World", true));
    }

    @Test
    void notAnagramWithoutIgnoreCase() {
        assertFalse(anagramString.isAnagram("hello", "world", false));
    }

    @Test
    void anagramWithDifferentCases() {
        assertTrue(anagramString.isAnagram("Triangle", "Integral", true));
    }

    @Test
    void notAnagramWithDifferentLengths() {
        assertFalse(anagramString.isAnagram("abc", "abcd", false));
    }

    @Test
    void anagramWithSpecialCharacters() {
        assertTrue(anagramString.isAnagram("a!b@c#", "c@b!a#", false));
    }


}