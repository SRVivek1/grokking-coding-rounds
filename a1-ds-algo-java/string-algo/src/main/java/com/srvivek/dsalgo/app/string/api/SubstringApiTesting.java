package com.srvivek.dsalgo.app.string.api;

/**
 * Substring
 * -----------
 *  A substring is a contiguous part of a string, i.e., a string inside another string.
 *  In general, for an string of size n, there are n*(n+1)/2 non-empty substrings.
 *  For example, Consider the string "geeks", There are 15 non-empty substrings
 *  The subarrays are:
 *   g, ge, gee, geek, geeks,
 *   e, ee, eek, eeks,
 *   e, ek, eks,
 *   k, ks,
 *   ks
 * Notes:
 *  --> substring() API:
 *      ---> Includes the given beginIndex character.
 *      ---> Excludes the given endIndex character considers chars till 'endIndex - 1'
 */
public class SubstringApiTesting {

    public static void main(String[] args) {

        final String s = "$Gee*k;s..fo, r'Ge^eks?";

        // T1 : Create a sub string from given index to end of string
        // from index '0'
        String res = s.substring(0);
        System.out.printf("Input: %s %n--> s.substring(0): %s %n", s, res);
        System.out.println("------------------------------");

        // T2 : Create a sub string from given index to end of string
        // from index '3' --> "e*k;s..fo, r'Ge^eks?"
        res = s.substring(3);
        System.out.printf("Input: %s %n--> s.substring(3): %s %n", s, res);
        System.out.println("------------------------------");

        // T3 : Create a sub string from given start and end indexes
        // from index '2'  to '6'--> "ee*k"
        res = s.substring(2, 6);
        System.out.printf("Input: %s %n--> s.substring(2, 6): %s %n", s, res);
        System.out.println("------------------------------");



    }

}
