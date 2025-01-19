package com.srvivek.dsalgo.app.reversal;

public class ReverseTheCompletetring {

    public static String reverseAlgo(String str) {

        if (str == null || str.isBlank()) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();

        // traverse from last index and put into SBuilder
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        String input = "Hello world java string";
        String output = reverseAlgo(input);

        System.out.println("Input  : " + input);
        System.out.println("Output : " + output);
    }
}
