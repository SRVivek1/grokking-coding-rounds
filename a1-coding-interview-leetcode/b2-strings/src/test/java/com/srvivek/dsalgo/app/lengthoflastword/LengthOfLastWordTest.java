package com.srvivek.dsalgo.app.lengthoflastword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthOfLastWordTest {

    private final LengthOfLastWord solution = new LengthOfLastWord();

    @Test
    @DisplayName("Test case with a standard phrase and trailing space")
    void testStandardPhraseWithTrailingSpace() {
        String s = "Hello World ";
        int expected = 5;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a standard phrase and no trailing space")
    void testStandardPhraseNoTrailingSpace() {
        String s = "Hello World";
        int expected = 5;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a single word")
    void testSingleWord() {
        String s = "Fly";
        int expected = 3;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with multiple spaces between words")
    void testMultipleSpaces() {
        String s = "   Hello    World   ";
        int expected = 5;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with only spaces")
    void testOnlySpaces() {
        String s = "     ";
        int expected = 0;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with an empty string")
    void testEmptyString() {
        String s = "";
        int expected = 0;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a null string")
    void testNullString() {
        String s = null;
        int expected = 0;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a string containing numbers and punctuation")
    void testWithPunctuation() {
        String s = "luffy is still joyboy.!!";
        int expected = 9;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a very long string")
    void testLongString() {
        String s = "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty";
        int expected = 6; // length of "twenty"
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    @DisplayName("Test case with a single letter as the last word")
    void testSingleLetterLastWord() {
        String s = "a b c d e f g";
        int expected = 1;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }
}
