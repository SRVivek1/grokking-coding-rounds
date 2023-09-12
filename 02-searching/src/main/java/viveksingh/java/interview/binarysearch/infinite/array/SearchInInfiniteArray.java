/**
 * 
 */
package viveksingh.java.interview.binarysearch.infinite.array;

import viveksingh.java.interview.binarysearch.RecursiveBinarySearch;
import viveksingh.java.interview.binarysearch.utils.DataUtil;

/**
 * @author vivek
 *
 */
public class SearchInInfiniteArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arrSize = 100;
		
		int[] arr = DataUtil.prepareRandomData(arrSize);
		int key = DataUtil.getRandomTargetIndex(arr, arrSize/2);

		// Search position in infinite array
		int result = findPosition(arr, key);
		DataUtil.processBinarySearchResult(result, key);
	}

	public static int findPosition(int[] arr, int key) {
		
		int left = 0;
		int right = 1;
		
		// Find right index
		while(key > arr[right]) {
			left = right;
			right = right * 2; // Exponential growth to get log(n) Time complexity.
			
			System.out.println("Left : " + left + ", Right : " + right);
		}
		
		// Blank line
		System.out.println();
		
		return RecursiveBinarySearch.recursiveBinarySearch(arr, key, left, right);
	}
	
	

}
