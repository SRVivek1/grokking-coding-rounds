package leetcode.p14.longestcommonprefix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void nullInputArray() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = null;
        assertEquals("", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void commonPrefixExists() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        assertEquals("fl", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void noCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"};
        assertEquals("", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void allStringsAreSame() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"test", "test", "test"};
        assertEquals("test", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void oneStringIsEmpty() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"", "b", "c"};
        assertEquals("", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void emptyArray() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {};
        assertEquals("", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void arrayWithOneString() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"single"};
        assertEquals("single", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void mixedCaseStrings() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"Flower", "flow", "flight"};
        assertEquals("", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void numericStrings() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"12345", "123", "12"};
        assertEquals("12", lcp.longestCommonPrefix_(strs));
    }

    @Test
    void specialCharacterStrings() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"@home", "@homework", "@homebase"};
        assertEquals("@home", lcp.longestCommonPrefix_(strs));
    }
}