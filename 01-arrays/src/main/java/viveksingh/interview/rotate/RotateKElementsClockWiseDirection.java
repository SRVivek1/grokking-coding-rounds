/**
 * 
 * Link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

	Example 1:
	
	Input: nums = [1,2,3,4,5,6,7], k = 3
	Output: [5,6,7,1,2,3,4]
	Explanation:
	rotate 1 steps to the right: [7,1,2,3,4,5,6]
	rotate 2 steps to the right: [6,7,1,2,3,4,5]
	rotate 3 steps to the right: [5,6,7,1,2,3,4]
	Example 2:
	
	Input: nums = [-1,-100,3,99], k = 2
	Output: [3,99,-1,-100]
	Explanation: 
	rotate 1 steps to the right: [99,-1,-100,3]
	rotate 2 steps to the right: [3,99,-1,-100]
	 
	
	Constraints:
	
	1 <= nums.length <= 105
	-231 <= nums[i] <= 231 - 1
	0 <= k <= 105
 */
package viveksingh.interview.rotate;

import viveksingh.interview.utils.ArrayUtils;

/**
 * @author vivek
 *
 */
public class RotateKElementsClockWiseDirection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		// Rotate last 3 elements
		rotate(arr, k);

		// Rotate last 10 elements
		rotate(arr, 10);

		// Rotate last 0 elements
		rotate(arr, 0);

	}

	/**
	 * Rotate the provide array from K index from last
	 * 
	 * @param arr
	 * @param k
	 */
	private static void rotate(int[] arr, int k) {

		ArrayUtils.printArray(arr, "Input array : ");
		System.out.println("Array size : " + arr.length);
		System.out.println("Reverse by : " + k);

		if (k <= 0) {
			System.out.println("Rotation must be greater than 0.");
			return;
		}

		// Calculate max rotations needed
		int r = k % arr.length;
		System.out.println("Rotations needed : " + r);

		// Reverse whole array
		reverse(arr, 0, arr.length - 1);

		// reverse first 'r' elements of array
		reverse(arr, 0, r - 1);

		// reverse after 'r' index till end.
		reverse(arr, r, arr.length - 1);

		ArrayUtils.printArray(arr, "Output array : ");

		System.out.println("=====================================================\n");
	}

	/**
	 * Reverse the give array within given start and end indexes.
	 * 
	 * Time complexity : O(n) Space complexity : O(1).
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private static void reverse(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}
}
