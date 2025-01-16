/**
 * 
 */
package viveksingh.java.interview.duplicate.first.repeating;

import java.util.HashMap;

/**
 * @author vivek
 *
 */
public class HashMapFindFirstRepeatingElement {

	public static int findFirstRepeatingElement(int[] arr) {
		
		System.out.println("HashMap solution");
		final HashMap<Integer, Integer> dataMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			
			Integer data = Integer.valueOf(arr[i]);
			
			if(dataMap.containsKey(data)) {
				return dataMap.get(data);
			}
			
			dataMap.put(data, i);
		}

		// No match found
		return -1;
	}
}
