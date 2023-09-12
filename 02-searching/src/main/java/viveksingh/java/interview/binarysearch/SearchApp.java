package viveksingh.java.interview.binarysearch;

import viveksingh.java.interview.binarysearch.utils.DataUtil;

public class SearchApp {

	public static void main(String[] args) {

		int[] arr1 = DataUtil.prepareRandomData();
		int target = DataUtil.getRandomTargetIndex(arr1);

		System.out.println("\nBinary Search ");
		int result = BinarySearch.binarySearch(arr1, target);
		DataUtil.processBinarySearchResult(result, target);

		System.out.println("\nBinary Search 2");
		result = BinarySearch.binarySearch2(arr1, target);
		DataUtil.processBinarySearchResult(result, target);

		System.out.println("\nRecursive Binary Search");
		result = RecursiveBinarySearch.recursiveBinarySearch(arr1, target, 0, (arr1.length - 1));
		DataUtil.processBinarySearchResult(result, target);

	}
}
