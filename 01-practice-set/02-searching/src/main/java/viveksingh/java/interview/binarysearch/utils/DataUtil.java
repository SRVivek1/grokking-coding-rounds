/**
 * 
 */
package viveksingh.java.interview.binarysearch.utils;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author vivek
 *
 */
public class DataUtil {

	/**
	 * Process the result.
	 * 
	 * @param result
	 */
	public static void processBinarySearchResult(int result, int target) {
		if (result == -1) {
			System.out.println(target + " not found.");
		} else {
			System.out.println(target + " found at index " + result);
		}
		
		// Blank line
		System.out.println();
	}
	
	/**
	 * Process the result considering -1 as data not found.
	 * 
	 * @param result
	 */
	public static void processResult(int result, int target) {
		if (result == -1) {
			System.out.println(target + " not found.");
		} else {
			System.out.println(target + " found at index " + result);
		}
		
		// Blank line
		System.out.println();
	}

	/**
	 * Randomly pick an index and value from the array.
	 * 
	 * @param arr1
	 * @return
	 */
	public static int getRandomTargetIndex(int[] arr1) {

		final int target = new Random().nextInt((arr1.length - 1) - 0 + 1) + 0;

		System.out.println("Index : " + target);
		System.out.println("Key : " + arr1[target]);

		// Blank line
		System.out.println();
		
		return arr1[target];
	}

	/**
	 * Randomly pick an index and value from the array index should be within
	 * maxIndex.
	 * 
	 * @param arr1
	 * @return
	 */
	public static int getRandomTargetIndex(int[] arr1, int maxIndex) {

		final int target = new Random().nextInt(maxIndex - 0 + 1) + 0;

		System.out.println("Index : " + target);
		System.out.println("Target : " + arr1[target]);
		
		// Blank line
		System.out.println();
		
		return arr1[target];
	}

	/**
	 * Generate array of size 20.
	 * 
	 * @return
	 */
	public static int[] prepareRandomData() {
		return prepareRandomData(20, 100);
	}

	/**
	 * Generate array of size 20.
	 * 
	 * @return
	 */
	public static int[] prepareRandomData(int size) {
		return prepareRandomData(size, size * 10);
	}

	/**
	 * Prepare a data array to search for element using binary search.
	 * 
	 * @return
	 */
	public static int[] prepareRandomData(final int size, final int bound) {

		// Size must be a positive number.
		if (size <= 0) {
			throw new RuntimeException("Input Size must be greater than 1");
		}

		// Create an empty array.
		int[] randomIntArr = IntStream.generate(() -> new Random().nextInt(bound)).distinct().limit(size).sorted()
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
	public static void print(int[] arr1) {

		System.out.print("Data : ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ", ");
		}
		// Blank line
		System.out.println("\n");
	}
}
