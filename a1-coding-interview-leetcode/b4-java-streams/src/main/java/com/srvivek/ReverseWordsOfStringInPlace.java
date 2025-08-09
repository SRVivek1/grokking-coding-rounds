package com.srvivek;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsOfStringInPlace {

  public static String reerseStringWordsInPlace(String str) {
    return Arrays.stream(str.split("\\s+"))
        .map(word -> new StringBuilder(word).reverse().toString())
        .collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    String str = "This is a sample message";
    String rev = reerseStringWordsInPlace(str);
    System.out.println("Input : " + str);
    System.out.println("Output : " + rev);
  }
}

/**
 * Output --------------- > Task :java8-streams:ReverseWordsOfStringInPlace.main() Input : This is a
 * sample message Output : sihT si a elpmas egassem
 */
