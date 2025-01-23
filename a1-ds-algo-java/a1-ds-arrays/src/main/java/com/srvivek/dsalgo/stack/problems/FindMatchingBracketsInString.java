package com.srvivek.dsalgo.stack.problems;

import java.util.Stack;

/**
 * Problem:
 * ------------
 * --> Given a String made up of following brackets []{}(),
 * determine whether the brackets properly match that is
 * each open bracket has a closing bracket.
 * <p>
 * --> Example:
 * 2. (()())       ----> Valid
 * 3. {]           ----> Invalid
 * 1. [{}]         ----> Valid
 * 4. [()])) ()    ----> Invalid
 * 5. [] {} ({})   ----> Valid
 */
public class FindMatchingBracketsInString {

    public static void main(String[] args) {

        String ip = "[(){}]";
        boolean res = hasMatchingBraces(ip);
        if (res) {
            System.out.printf("%s has valid braces.%n", ip);
        } else {
            System.out.printf("%s has invalid braces.%n", ip);
        }
        System.out.println("---------------------------------");

        ip = "{]";
        res = hasMatchingBraces(ip);
        if (res) {
            System.out.printf("%s has valid braces.%n", ip);
        } else {
            System.out.printf("%s has invalid braces.%n", ip);
        }
        System.out.println("---------------------------------");

        ip = "[{}]";
        res = hasMatchingBraces(ip);
        if (res) {
            System.out.printf("%s has valid braces.%n", ip);
        } else {
            System.out.printf("%s has invalid braces.%n", ip);
        }
        System.out.println("---------------------------------");

        ip = "[()])) ()";
        res = hasMatchingBraces(ip);
        if (res) {
            System.out.printf("%s has valid braces.%n", ip);
        } else {
            System.out.printf("%s has invalid braces.%n", ip);
        }
        System.out.println("---------------------------------");

        ip = "[] {} ({})";
        res = hasMatchingBraces(ip);
        if (res) {
            System.out.printf("%s has valid braces.%n", ip);
        } else {
            System.out.printf("%s has invalid braces.%n", ip);
        }
    }

    public static boolean hasMatchingBraces(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.toString(c).isBlank()) {
                continue;
            }

            // is left/opening bracket
            if (isOpeningBracket(c)) {
                stack.push(c);
                continue;
            }

            char rev = getOpeningdBracket(c);
            if (stack.isEmpty() || stack.pop() != rev) {
                System.out.println("Missing opening brackets for - " + rev);
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if given char is opening braces/bracket - '[', '{' or '('.
     *
     * @return boolean
     */
    private static boolean isOpeningBracket(char c) {

        if (c == '[' || c == '{' || c == '(')
            return true;

        return false;
    }

    /**
     * Get reversed bracket/braces for the provided open bracket.
     *
     * @param close
     * @return char
     */
    private static char getOpeningdBracket(char close) {
        if (close == ']') {
            return '[';
        } else if (close == '}') {
            return '{';
        } else if (close == ')') {
            return '(';
        } else {
            throw new RuntimeException("Unsupported opening bracket/braces");
        }
    }
}
