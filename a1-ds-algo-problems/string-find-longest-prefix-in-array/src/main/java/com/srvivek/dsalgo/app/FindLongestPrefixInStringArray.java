package com.srvivek.dsalgo.app;

import java.util.Arrays;

/**
 * Problem statement.
 * <p>
 * Longest Common Prefix
 * ----------------------------------
 * String[] strArr= {"flow","flop","flight"}
 * Output: -> fl
 * String[] strArr= {"flow","flop","flight", "flower"}
 * Output: -> fl
 * String[] strArr= {"flow","flop","flower"}
 * Output: -> flo
 * String[] strArr= {"flow","flop","flight", "descope", "desire"}
 * Output: -> ""
 */
public class FindLongestPrefixInStringArray {


    public static String findLongestPrefix(String[] arr) {

        if (arr == null || arr.length == 0) {
            return "";
        }

        if (arr.length == 1) {
            return arr[0];
        }

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {

        String[] strArr = {"flow", "flop", "flight"};
        String[] strArr1 = {"flow", "flop", "flight", "flower"};
        String[] strArr2 = {"flow", "flop", "flower"};
        String[] strArr3 = {"flow", "flop", "flight", "descope", "desire"};

        String res = findLongestPrefix(strArr);
        System.out.println(String.format("Input: %s \n Output: %s", Arrays.asList(strArr), res));

        res = findLongestPrefix(strArr1);
        System.out.println(String.format("Input: %s \n Output: %s", Arrays.asList(strArr1), res));

        res = findLongestPrefix(strArr2);
        System.out.println(String.format("Input: %s \n Output: %s", Arrays.asList(strArr2), res));

        res = findLongestPrefix(strArr3);
        System.out.println(String.format("Input: %s \n Output: %s", Arrays.asList(strArr3), res));

    }
}