package com.srvivek.dsalgo.app.lengthoflastword;

public class LengthOfLastWord {

    /**
     * Interview settings as it demonstrates a solid understanding
     * of string manipulation and algorithm design.
     *
     * @param s input string
     * @return length of string
     */
    public int lengthOfLastWord(String s) {
            if( s == null || s.isBlank()) return 0;

            int r = s.length() - 1;
            while(r >= 0 && Character.isWhitespace(s.charAt(r))) r--;

            int l = r;
            while( l >= 0 && !Character.isWhitespace(s.charAt(l))) l--;

            return r - l;
    }
}
