/**
 * 
 */
package viveksingh.java.interview.duplicate.first.repeating;

import viveksingh.java.interview.binarysearch.utils.DataUtil;

/**
 * @author vivek
 *
 */
public class FindFirstRepeatingElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("\n------------ Array without duplicates ---------------");
		// int[] arr = DataUtil.prepareRandomData(10);
		// int key = DataUtil.getRandomTargetIndex(arr);
		int[] arr = new int[] { 6, 8, 20, 27, 41, 52, 61, 70, 77, 92, 93 };
		
		DataUtil.print(arr);

		// HahSet solution
		int result = HashSetToFindFirstRepeatingElement.findFirstRepeatingElement(arr);
		System.out.println("First repeating element - duplicate found at index - " + result);
		System.out.println();
		
		// HashMap solution
		result = HashMapFindFirstRepeatingElement.findFirstRepeatingElement(arr);
		System.out.println("First repeating element - found at index - " + result);
		

		System.out.println("\n------------ Array with duplicates ---------------");
		arr = new int[] { 6, 8, 20, 27, 41, 52, 61, 27, 77, 92, 93 };
		
		DataUtil.print(arr);

		// HahSet solution
		result = HashSetToFindFirstRepeatingElement.findFirstRepeatingElement(arr);
		System.out.println("First repeating element - duplicate found at index - " + result);
		System.out.println();
		
		// HashMap solution
		result = HashMapFindFirstRepeatingElement.findFirstRepeatingElement(arr);
		System.out.println("First repeating element - found at index - " + result);
	}

}
