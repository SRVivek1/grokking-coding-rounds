package viveksingh.java.interview.binarysearch;

public class BinarySearch {

	/**
	 * Use binary search to find the target in the array.
	 * 
	 * @param arr1
	 * @param target
	 */
	public static int binarySearch(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = left + ((right - left) / 2);

			System.out.println("Search range [ " + left + " ... " + mid + " .... " + right + "]");

			// check if target is at mid index
			if (arr[mid] == target) {
				return mid;
			}

			// if target is greater than mid the search in right half
			if (target > arr[mid]) {
				left = mid + 1;
			}

			// if target is less than mid the search in left half
			if (target < arr[mid]) {
				right = mid - 1;
			}
		}

		return -1;

	}

	/**
	 * Notepad++
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearch2(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = left + ((right - left) / 2);

			System.out.println("Search range [ " + left + " ... " + mid + " .... " + right + "]");

			if (target == arr[mid]) {
				return mid;
			} else if (target < arr[mid]) {
				right = mid - 1;
			} else if (target > arr[mid]) {
				left = mid + 1;
			}
		}

		return -1;
	}
}