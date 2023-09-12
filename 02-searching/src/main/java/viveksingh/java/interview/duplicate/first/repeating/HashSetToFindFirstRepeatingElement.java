/**
 * 
 */
package viveksingh.java.interview.duplicate.first.repeating;

import java.util.HashSet;

/**
 * @author vivek
 *
 */
public class HashSetToFindFirstRepeatingElement {

	/**
	 * Returns index of first repeating element or -1 if element not found.
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int findFirstRepeatingElement(int[] arr) {
		
		System.out.println("HashSet solution");
		final HashSet<Integer> dataset = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			
			Integer data = Integer.valueOf(arr[i]);

			if(dataset.contains(data)) {
				System.out.println("Data is present : " + data);
				return i;
			}
			
			dataset.add(data);
		
		}
		
		return -1;
	}
}
