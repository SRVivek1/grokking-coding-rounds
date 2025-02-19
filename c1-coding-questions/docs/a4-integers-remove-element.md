# Integers: Find the only unique number in an array
## Problem statements:
- Given an integer array *nums* and an integer *val*, remove all occurrences of *val* in *nums* ***in-place***. The order of the elements may be changed. 
  - Then return the number of elements in nums which are not equal to val.

- Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
  - Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
  - Return k.

- Custom Judge:
  - The judge will test your solution with the following code:
    - int[] nums = [...]; // Input array
    - int val = ...; // Value to remove
    - int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

    - int k = removeElement(nums, val); // Calls your implementation

    ```java
      assert k == expectedNums.length;
      sort(nums, 0, k); // Sort the first k elements of nums
      for (int i = 0; i < actualLength; i++) {
          assert nums[i] == expectedNums[i];
      }
    ```
  - If all assertions pass, then your solution will be accepted.

 
- **Example 1:**
  - **Input:** nums = [3,2,2,3], val = 3
  - **Output:** 2, nums = [2,2,_,_]
  - **Explanation:**
    - Your function should return k = 2, with the first two elements of nums being 2.
  - **Note:** 
    - It does not matter what you leave beyond the returned k (hence they are underscores).


- **Example 2:**
  - **Input:** nums = [0,1,2,2,3,0,4,2], val = 2
  - **Output:** 5, nums = [0,1,4,0,3,_,_,_]
  - **Explanation:** 
    - Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
  - **Note:** 
    - The five elements can be returned in any order.
    - It does not matter what you leave beyond the returned k (hence they are underscores).
 

- **Constraints:**
  - 0 <= nums.length <= 100
  - 0 <= nums[i] <= 50
  - 0 <= val <= 100


## Soltuions:
### 1. Approach: Using two pointer approach
  - A common and effective technique for in-place array manipulation is using two pointers.
  - Here's how you can apply it:
    - k (or next_pos): This pointer will track where the next element that isn't equal to val should be placed.  It starts at 0.
    - i (or current): This pointer iterates through the entire array from the beginning.

  - **Logic:**
    - For each element nums[i]:
      - If nums[i] is not equal to val:
        - Copy nums[i] to nums[k].
        - Increment k.
    - If nums[i] is equal to val:
      - Do nothing (effectively skipping this element).
    - Return k: After the loop finishes, k will represent the number of elements that are not equal to val, which is what you need to return.

  - **Implementation:**
  ```java
      /**
      * Remove the elements where `element == val`.
      * Returns the index k, which has elements `element != val`
      * TC: O(n)
      * SC: O(n)
      *
      * @param nums
      * @return
      */
      public int removeElement(int[] nums, int val) {
        
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
  ```
