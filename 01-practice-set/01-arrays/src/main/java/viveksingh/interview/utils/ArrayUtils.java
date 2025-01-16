/**
 * 
 */
package viveksingh.interview.utils;

import java.util.stream.Stream;

/**
 * @author vivek
 *
 */
public class ArrayUtils {

	/**
	 * Print input array data and given message.
	 * 
	 * @param arr
	 */
	public static void printArray(Integer[] arr, String message) {

		printArray(Stream.of(arr).mapToInt(i -> {
			if (i != null) {
				return i.intValue();
			} else {
				return 0;
			}
		}).toArray(), message);

	}

	/**
	 * Print input array data and given message.
	 * 
	 * @param arr
	 */
	public static void printArray(int[] arr, String message) {

		System.out.print(message + " ");
		printArray(arr);
	}

	/**
	 * Print input array data.
	 * 
	 * @param arr
	 */
	public static void printArray(int[] arr) {

		if (arr == null || arr.length == 0) {
			System.out.println("Null/Empty array.");
			return;
		}

		System.out.print("[");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
	}
}
