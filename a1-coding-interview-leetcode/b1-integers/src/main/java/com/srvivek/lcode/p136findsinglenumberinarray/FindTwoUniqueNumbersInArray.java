package com.srvivek.lcode.p136findsinglenumberinarray;

public class FindTwoUniqueNumbersInArray {

  public static void main(String[] args) {
    int[] inp1 = {1, 4};
    int[] inp2 = {1, 2, 4, 5, 7, 9, 1, 2, 4, 5};
    int[] inp3 = {7, 2, 4, 5, 2, 4, 5, 15};

    print(inp1);
    int[] res = findUniqueNumbers(inp1);
    print(res);

    print(inp2);
    res = findUniqueNumbers(inp2);
    print(res);

    print(inp3);
    res = findUniqueNumbers(inp3);
    print(res);
  }

  /**
   * Find the 2 unique numbers in the array of duplicates.
   *
   * @param nums input array
   * @return result array
   */
  public static int[] findUniqueNumbers(int[] nums) {
    int[] res = new int[2];

    // Step - 1 : Find XOR of the 2 unique numbers
    int xors = 0;
    for (int num : nums) {
      xors ^= num;
    }

    // step-2: Find the right most set bit
    int rightMostSetBit = xors & (-xors);

    // step-3: filter both unique values
    // Approach: In the given unique number only one have right bit set '1'
    for (int num : nums) {
      if ((num & rightMostSetBit) != 0) {
        res[0] ^= num;
      } else {
        res[1] ^= num;
      }
    }
    return res;
  }

  /** Print array */
  public static void print(int[] nums) {
    System.out.print("Array: [");
    for (int num : nums) {
      System.out.print(num + ", ");
    }
    System.out.println("]");
  }
}
