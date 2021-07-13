/**
 * 
 * Reference:
 * 	1. https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 * 
 * 
 * Requirement:
 * ---------------------------
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates 
 * in-place (an algorithm which transforms input using no auxiliary data structure) such that each unique 
 * element appears only once. The relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be 
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. 
 * 
 * Custom Judge:
 * -----------------------
 * The judge will test your solution with the following code:
	
	int[] nums = [...]; // Input array
	int[] expectedNums = [...]; // The expected answer with correct length
	
	int k = removeDuplicates(nums); // Calls your implementation
	
	assert k == expectedNums.length;
	for (int i = 0; i < k; i++) {
	    assert nums[i] == expectedNums[i];
	}
	
 *  If all assertions pass, then your solution will be accepted.
 * 
 * 
 * -----------------------
 * 
 */
package viveksingh.interview.duplicates;

/**
 * @author vivek
 *
 */
public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Input array
		int[] nums = { 1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7, 8 };

		// Expected output
		int[] expectedResult = { 1, 2, 3, 4, 5, 6, 7 };

		printArray(nums, nums.length, "Input Array");
		printArray(expectedResult, expectedResult.length, "Expected result array");

		int lastIndex = removeDuplicates(nums);

		System.out.println("Last unique element index : " + lastIndex);
		printArray(nums, lastIndex, "Output Array");

	}

	/**
	 * Take all unique elements and put them in first position with space
	 * complexicity of O(1).
	 * 
	 * Expects : sorted array
	 * 
	 * @param sortedArray
	 * 
	 * @return
	 */
	private static int removeDuplicates(int[] sortedArray) {

		if (sortedArray == null) {
			return -1;
		}

		if (sortedArray.length == 0 || sortedArray.length == 1) {
			return sortedArray.length;
		}

		// Store index of next unique element
		int lastIndex = 0;

		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] != sortedArray[i + 1]) {
				sortedArray[lastIndex++] = sortedArray[i];
			}
		}

		// check for last element
		sortedArray[lastIndex++] = sortedArray[sortedArray.length - 1];

		return lastIndex;
	}

	/**
	 * Print input array.
	 * 
	 * @param array
	 */
	private static void printArray(int[] array, int index, String msg) {
		System.out.println(msg);
		System.out.println("============================================");
		printArray(array, index);
	}

	/**
	 * Print input array.
	 * 
	 * @param array
	 */
	private static void printArray(int[] array, int index) {
		System.out.println("Index till print : " + index);
		System.out.println("Array length : " + array.length);
		for (int i = 0; i < index; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
