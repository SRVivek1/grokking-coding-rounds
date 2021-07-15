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

import java.util.HashSet;

import viveksingh.interview.utils.ArrayUtils;

/**
 * @author vivek
 *
 */
public class CheckForUniqueElementsUsingHashSet {

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
	 * Space complexity : O(n) Time complexity : O(n)
	 * 
	 * Leet code: --------------- Runtime: 5 ms Memory Usage: 44.x MB
	 * 
	 * @param arr
	 * @return
	 */
	private static Boolean containsDuplicate(int[] arr) {

		if (arr.length == 0) {
			return false;
		}
		final HashSet<Integer> data = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			// Check if data exists
			if (data.contains(arr[i])) {
				System.out.println("Duplicate found : " + arr[i] + ", Index : " + (i + 1));
				return true;
			}
			// add data
			data.add(arr[i]);
		}

		return false;
	}

}
