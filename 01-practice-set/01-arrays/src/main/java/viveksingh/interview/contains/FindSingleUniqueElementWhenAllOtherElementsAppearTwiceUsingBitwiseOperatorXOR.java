/**
 * 
 * RefLink : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * 
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

	You must implement a solution with a linear runtime complexity and use only constant extra space.
	
	Example 1:
	-------------------
	Input: nums = [2,2,1]
	Output: 1
	
	Example 2:
	-------------------
	Input: nums = [4,1,2,1,2]
	Output: 4
	
	Example 3:
	-------------------
	Input: nums = [1]
	Output: 1
 */
package viveksingh.interview.contains;

import viveksingh.interview.utils.ArrayUtils;

/**
 * @author vivek
 *
 */
public class FindSingleUniqueElementWhenAllOtherElementsAppearTwiceUsingBitwiseOperatorXOR {

	public static void main(String[] args) {

		int[] input_arr_1 = { 4, 1, 2, 1, 2 };

		int[] input_arr_2 = { 2, 2, 1 };

		int[] input_arr_3 = { 1 };

		int[] input_arr_empty = {};

		int[] input_arr_null = null;

		int result = findSingleUniqueElement(input_arr_1);
		ArrayUtils.printArray(input_arr_1, "Input array : ");
		System.out.println("Unique element is : " + result + "\n");

		result = findSingleUniqueElement(input_arr_2);
		ArrayUtils.printArray(input_arr_2, "Input array : ");
		System.out.println("Unique element is : " + result + "\n");

		result = findSingleUniqueElement(input_arr_3);
		ArrayUtils.printArray(input_arr_3, "Input array : ");
		System.out.println("Unique element is : " + result + "\n");

		result = findSingleUniqueElement(input_arr_empty);
		ArrayUtils.printArray(input_arr_empty, "Input array : ");
		System.out.println("Unique element is : " + result + "\n");

		result = findSingleUniqueElement(input_arr_null);
		ArrayUtils.printArray(input_arr_null, "Input array : ");
		System.out.println("Unique element is : " + result + "\n");
	}

	/**
	 * 
	 * Using bitwise operator, bitwise operator results '0' when XOR ('^') with
	 * it-self.
	 * 
	 * Time complexity : O(n) 
	 * 
	 * Space complexity : O(1)
	 * 
	 * @param arr
	 * @return
	 */
	private static int findSingleUniqueElement(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		if (arr.length == 1) {
			return arr[0];
		}

		int result = arr[0];

		for (int i = 1; i < arr.length; i++) {
			// XOR operator '^'.
			result = result ^ arr[i];
		}

		return result;
	}

}
