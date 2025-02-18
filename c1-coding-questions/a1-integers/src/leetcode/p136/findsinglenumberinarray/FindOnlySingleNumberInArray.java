package leetcode.p136.findsinglenumberinarray;

import java.util.HashSet;
import java.util.Set;

public class FindOnlySingleNumberInArray {

    public static void main(String[] args) {

        int[] input1 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 5};
        int[] input2 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] input3 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6};

        System.out.println("************************* Bitwise XOR *****************************");
        int res = findSingleNumberBitwiseXor(input1);
        print(input1);
        System.out.println("Single number : " + res);

        res = findSingleNumberBitwiseXor(input2);
        print(input2);
        System.out.println("Single number : " + res);


        res = findSingleNumberBitwiseXor(input3);
        print(input3);
        System.out.println("Single number : " + res);

        System.out.println("************************* HashSet *****************************");
        res = findSingleNumberHashSet(input1);
        print(input1);
        System.out.println("Single number : " + res);

        res = findSingleNumberHashSet(input2);
        print(input2);
        System.out.println("Single number : " + res);


        res = findSingleNumberHashSet(input3);
        print(input3);
        System.out.println("Single number : " + res);

    }

    /**
     * Find Unique number in an array using Bitwise XOR operator.
     * TC: O(n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int findSingleNumberBitwiseXor(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    /**
     * Find unique element in the array using HashSet.
     * TC: O(n)
     * SC: O(n)
     *
     * @param nums
     * @return
     */
    public static int findSingleNumberHashSet(int[] nums) {
        final Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (numSet.contains(t)) {
                numSet.remove(t);
            } else {
                numSet.add(t);
            }
        }
        if (numSet.size() == 1) {
            return numSet.iterator().next();
        } else {
            return 0;
        }
    }

    /**
     * Print the array.
     *
     * @param input
     */
    private static void print(int[] input) {
        System.out.print("Array : [");
        for (int r : input) {
            System.out.print(r + ", ");
        }
        System.out.println("]");
    }
}
