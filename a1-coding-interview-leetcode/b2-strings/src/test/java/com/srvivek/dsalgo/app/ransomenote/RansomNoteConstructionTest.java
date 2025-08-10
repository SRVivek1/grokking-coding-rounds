package com.srvivek.dsalgo.app.ransomenote;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RansomNoteConstructionTest {

    private final RansomNoteConstruction rnc = new RansomNoteConstruction();

    @Test
    void testBasicTrueCase() {
        assertTrue(rnc.ransomNote("a", "a"));
        assertTrue(rnc.ransomNote("aa", "aab"));
        assertTrue(rnc.ransomNote("abc", "abcdef"));
    }

    @Test
    void testBasicFalseCase() {
        assertFalse(rnc.ransomNote("a", "b"));
        assertFalse(rnc.ransomNote("aa", "ab"));
        assertFalse(rnc.ransomNote("aabb", "ab"));
    }

    @Test
    void testEdgeCase_RansomNoteEmpty() {
        // An empty ransom note can always be constructed.
        assertTrue(rnc.ransomNote("", "abc"));
        assertTrue(rnc.ransomNote("", ""));

        assertTrue(rnc.ransomNote("", " ")); // Test with a magazine with whitespace

        assertFalse(rnc.ransomNote("   ", " ")); // One space magazine can't be used to create more than a space ransom note.
    }

    @Test
    void testEdgeCase_MagazineEmpty() {
        // A non-empty ransom note cannot be constructed from an empty magazine.
        assertFalse(rnc.ransomNote("a", ""));
        assertFalse(rnc.ransomNote("abc", ""));
    }

    @Test
    void testEdgeCase_RansomNoteLongerThanMagazine() {
        // A ransom note longer than the magazine cannot be constructed.
        assertFalse(rnc.ransomNote("ab", "a"));
        assertFalse(rnc.ransomNote("abcdef", "abc"));
    }

    @Test
    void testEdgeCase_CharactersWithSameFrequency() {
        // Test where frequencies match exactly.
        assertTrue(rnc.ransomNote("abc", "bca"));
        assertTrue(rnc.ransomNote("aabb", "bbaa"));
    }

    @Test
    void testEdgeCase_DuplicateCharactersInRansomNote() {
        // Ensure that duplicates are handled correctly.
        assertTrue(rnc.ransomNote("aab", "aba"));
        assertTrue(rnc.ransomNote("aabb", "babac"));
        assertFalse(rnc.ransomNote("aabbc", "baba"));
    }

    @Test
    void testCaseInsensitiveCheck_ProblemStatementImpliesLowerCaseOnly() {
        // The problem statement implies all inputs are lowercase.
        // This test is to highlight that the current solution is case-sensitive and would fail
        // if uppercase letters were introduced.
        // The current implementation is correct based on the typical problem constraints.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> rnc.ransomNote("A", "a"));
    }

    @Test
    void testWithSpaces() {
        // The current solution will throw an exception if spaces are present.
        // It's important to know this limitation based on the character set.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> rnc.ransomNote("a b", "a b"));
    }

    @Test
    void testComplexCase() {
        // A more complex case with various characters and frequencies.
        assertTrue(rnc.ransomNote("programming", "magazinerunningprograms"));
        assertFalse(rnc.ransomNote("programming", "magazinerunningprogra")); // Missing one 'm'
    }
}