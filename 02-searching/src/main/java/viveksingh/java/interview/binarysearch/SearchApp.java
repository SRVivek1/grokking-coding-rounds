package viveksingh.java.interview.binarysearch;

import java.util.Random;
import java.util.stream.IntStream;

public class SearchApp {

	public static void main(String[] args) {

		int[] arr1 = prepareData();
		int target = getTargetIndex(arr1);

		System.out.println("\nBinary Search ");
		int result = BinarySearch.binarySearch(arr1, target);
		processResult(result, target);

		System.out.println("\nBinary Search 2");
		result = BinarySearch.binarySearch2(arr1, target);
		processResult(result, target);

		System.out.println("\nRecursive Binary Search");
		result = RecursiveBinarySearch.recursiveBinarySearch(arr1, target, 0, (arr1.length - 1));
		processResult(result, target);

	}

	/**
	 * Process the result.
	 * 
	 * @param result
	 */
	private static void processResult(int result, int target) {
		if (result == -1) {
			System.out.println(target + " not found.");
		} else {
			System.out.println(target + " found at index " + result);
		}
	}

	/**
	 * Randomly pick an index and value from the array.
	 * 
	 * @param arr1
	 * @return
	 */
	private static int getTargetIndex(int[] arr1) {

		final int target = new Random().nextInt((arr1.length - 1) - 0 + 1) + 0;

		System.out.println("Index : " + target);
		System.out.println("Target : " + arr1[target]);

		return arr1[target];
	}

	/**
	 * Generate array of size 20.
	 * 
	 * @return
	 */
	public static int[] prepareData() {
		return prepareData(20);
	}

	/**
	 * Prepare a data array to search for element using binary search.
	 * 
	 * @return
	 */
	public static int[] prepareData(int size) {

		// Size must be a positive number.
		if (size <= 0) {
			throw new RuntimeException("Input Size must be greater than 1");
		}

		// Create an empty array.
		int[] randomIntArr = IntStream.generate(() -> new Random().nextInt(100)).distinct().limit(size).sorted()
				.toArray();

		// print
		print(randomIntArr);

		return randomIntArr;
	}

	/**
	 * Print array data.
	 * 
	 * @param arr1
	 */
	private static void print(int[] arr1) {

		System.out.print("Data : ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ", ");
		}
		System.out.println();
	}
}
