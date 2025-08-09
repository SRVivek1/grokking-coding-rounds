package com.srvivek.dsalgo.app.reversal;

public class ReverseStringWords {

  public static void main(String[] args) {
    ReverseStringWords rw = new ReverseStringWords();
    String s = "  the sky    is blue.  ";
    s = "hello world";
    String res = rw.reverseStringByWords(s);

    System.out.printf("Input : [%s]%n", s);
    System.out.printf("Output: [%s]%n", res);
  }

  public String reverseStringByWords(String s) {
    if (s == null || s.isBlank()) return "";
    if (s.length() == 1) return s;

    char[] arr = s.toCharArray();

    // Step-1: Reverse entire string
    reverse(arr, 0, arr.length - 1);

    // step-2: reverse each word
    reverseWord(arr);

    // Step-3: clean spaces
    int len = cleanSpaces(arr);

    String res = new String(arr, 0, len);
    System.out.printf("Input : [%s] %nOutput: [%s] %n", s, res);
    return res;
  }

  public int cleanSpaces(char[] arr) {
    int l = 0, r = 0;
    while (r < arr.length) {
      while (r < arr.length && arr[r] == ' ') r++;
      while (r < arr.length && arr[r] != ' ') {
        arr[l++] = arr[r++];
      }
      // Skip extra spaces between words
      while (r < arr.length && arr[r] == ' ') r++;
      if (r < arr.length) arr[l++] = ' ';
    }
    // Remove trailing space if it exists
    return (l > 0 && arr[l - 1] == ' ') ? l - 1 : l;
  }

  public void reverseWord(char[] arr) {
    int l = 0, r = 0;
    while (r < arr.length) {
      // Find start of the word
      while (l < arr.length && arr[l] == ' ') l++;
      if (l >= arr.length) break;

      // Find end of the word
      r = l;
      while (r < arr.length && arr[r] != ' ') r++;

      // reverse word
      if (l < r) reverse(arr, l, r - 1);

      // move to next word
      l = r;
    }
  }

  public void reverse(char[] arr, int start, int end) {
    while (start < end) {
      char temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
  }
}
