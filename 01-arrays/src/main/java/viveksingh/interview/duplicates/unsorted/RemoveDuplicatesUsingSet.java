/**
 * Problem Statement
 * ---------------------
 * Given an unsorted array of integers, print the array after removing the duplicate elements from it. We need to print distinct array elements according to their first occurrence.

	Examples: 
	
	Input: arr[] = { 1, 2, 5, 1, 7, 2, 4, 2}
	Output: 1 2 5 7 4
	Explanation: {1, 2} appear more than one time.
	
	Input: arr[] = { 3, 3, 4, 1, 1}
	Output: 3 4 1
 */
package viveksingh.interview.duplicates.unsorted;

import java.util.LinkedHashSet;

/**
 * @author vivek
 *
 */
public class RemoveDuplicatesUsingSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {1, 2, 5, 1, 7, 2, 4, 2};
		
		Integer[] result = removeDuplicates(arr);
		
		// Print array
		for (Integer i : result) {
			System.out.print(i + ", ");
		}
	}

	/**
	 * Remove duplicate elements.
	 * 
	 * @param arr
	 * @return
	 */
	private static Integer[] removeDuplicates(int[] arr) {

		final LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>();
		
		for(int i : arr) {
			uniqueElements.add(i);
		}
		
		return uniqueElements.toArray(new Integer[arr.length]);
	}

}

/**
 * Output
 * -------------------
 *  1, 2, 5, 7, 4, null, null, null, 
 * 
 */
