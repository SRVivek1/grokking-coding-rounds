/**
 * 
 */
package viveksingh.java.interview.binarysearch;

/**
 * @author vivek
 *
 */
public class RecursiveBinarySearch {

	/**
	 * Recursive binary search.
	 * 
	 * @param arr
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	public static int recursiveBinarySearch(int[] arr, int target, int left, int right) {

		while (left <= right) {

			int mid = left + (right - left) / 2;
			
			System.out.println("Search range [ " + left + " ... " + mid + " .... " + right + "]");

			if (target == arr[mid]) {
				return mid;
			} else if (target < arr[mid]) {
				// search in left side of sub-array
				return recursiveBinarySearch(arr, target, left, mid - 1);
			} else if (target > arr[mid]) {
				// search in right side of sub-array
				return recursiveBinarySearch(arr, target, (mid + 1), right);
			}
		}
				
		return -1;
	}

}
