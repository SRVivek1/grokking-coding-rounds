package leetcode.p344.reversestring;

public class ReverseString {

    public static void main(String[] args) {
        String s = "hello";
        String res = reverse(s);
        System.out.printf("Input: %s %nOutput: %s", s, res);
    }

    public static String reverse(String s) {
        char[] chars  = s.toCharArray();
        reverse(chars);
        return new String(chars);
    }

    public static void reverse(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
