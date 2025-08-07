package com.srvivek.dsalgo.app.reversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReverseStringWordsTest {

    private static ReverseStringWords reverseStringWords;

    @BeforeAll
    public static void setUp() {
        reverseStringWords = new ReverseStringWords();
    }

    @Test
    public void testNullString() {
        String s = null;
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testEmptyString() {
        String s = "";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testBlankString() {
        String s = "          ";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testSingleWord() {
        String s = "Hello";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("Hello", result);
    }

    @Test
    public void testSingleWordWithSpaces() {
        String s = "   Hello       ";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("Hello", result);
    }


    @Test
    public void testReverseWords() {
        String s = "Hello World";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("World Hello", result);
    }

    @Test
    public void testReverseWordsWithSpaces() {
        String s = "  Hello       World     ";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("World Hello", result);
    }

    @Test
    public void testReverseWordsWithSpaces2() {
        String s = "  the sky  is    blue.   ";
        String result = reverseStringWords.reverseStringByWords(s);
        Assertions.assertEquals("blue. is sky the", result);
    }
}
