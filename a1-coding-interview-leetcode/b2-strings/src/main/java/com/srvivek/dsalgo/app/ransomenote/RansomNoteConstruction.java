package com.srvivek.dsalgo.app.ransomenote;

public class RansomNoteConstruction {

    public boolean ransomNote(String ransomNote, String magazine) {

        // Ease cases
        if(ransomNote.isEmpty()) return true;

        if(magazine.isEmpty()) {
            return ransomNote.isEmpty();
        }

        if(ransomNote.length() > magazine.length()) return false;

        final int[] fr = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            fr[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if(fr[index] == 0) return false;
            fr[index]--;
        }

        return true;
    }

}
