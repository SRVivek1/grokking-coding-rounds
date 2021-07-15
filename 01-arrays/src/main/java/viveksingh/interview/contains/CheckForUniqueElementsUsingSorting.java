/**
 * 
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * 
 * 
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

	Example 1:
	
	Input: nums = [1,2,3,1]
	Output: true
	Example 2:
	
	Input: nums = [1,2,3,4]
	Output: false
	Example 3:
	
	Input: nums = [1,1,1,3,3,4,3,2,4,2]
	Output: true
	 
	
	Constraints:
	
	1 <= nums.length <= 105
	-109 <= nums[i] <= 109
 */
package viveksingh.interview.contains;

import java.util.Arrays;

import viveksingh.interview.utils.ArrayUtils;

/**
 * @author vivek
 *
 */
public class CheckForUniqueElementsUsingSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 1 };

		ArrayUtils.printArray(arr, "Input array : ");

		// Check if array has duplicate elements
		Boolean result = containsDuplicate(arr);
		System.out.println("Contains duplicates : " + result);
	}

	/**
	 * Returns true if it has duplicate elements.
	 * 
	 * Time complexity : n log n
	 * 
	 * Leet code:
	 * ---------------
	 * Runtime: 3 ms
	 * Memory Usage: 41.9 MB
	 * 
	 * @param arr
	 * @return
	 */
	private static Boolean containsDuplicate(int[] arr) {

		if (arr.length == 0) {
			return false;
		}
		
		// Sort the array
		Arrays.sort(arr);
		ArrayUtils.printArray(arr, "Sorted Array : ");

		// Check for duplicates
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println("Duplicate found : " + arr[i] + ", Index : " + (i + 1));
				return true;
			}
		}
		return false;
	}

}
