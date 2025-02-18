# Integers: Find the only unique number in an array
## Problem statements:
- Given a non-empty array of integers `nums` every element appears twice except for one. Find that single/unique integer value.
- Constraints:
  - The solution should have linear time complexity : O(n).
  - Space complexicity should be O(1).

- Example 1:
  - **Input:** `nums = [2,2,1]`
  - **Output:** `1`

- Example 2:
  - **Input:** `nums = [4,1,2,1,2]`
  - **Output:** `4`

- Example 3:
  - **Input:** `nums = [1]`
  - **Output:** `1`


## Soltuions:
### 1. Using HashSet to filter unique element
  - In this approach we'll iterate the array and check
    - If element is not present in HashSet add it 
    - If element is present in HashSet remove it 
  - Once all elements are iterated:
    - If set is empty there are no uniqueu elements
    - if set has more than 1 elements, there are multiple unique elements
    - if there's exactly one element, return it as ans.
  ```java
      /**
      * Find unique element in the array using HashSet.
      * TC: O(n)
      * SC: O(n)
      *
      * @param nums
      * @return
      */
      public static int findSingleNumberHashSet(int[] nums) {
          final Set<Integer> numSet = new HashSet<>();
          for (int i = 0; i < nums.length; i++) {
              int t = nums[i];
              if (numSet.contains(t)) {
                  numSet.remove(t);
              } else {
                  numSet.add(t);
              }
          }
          if (numSet.size() == 1) {
              return numSet.iterator().next();
          } else {
              return 0;
          }
      }
  ```


### 2. Using Bitwise XOR operator
  - Due to following bitwise XOR property we can find the unique element.
    - XOR with same value results in *0*.
    - XOR any value with *0* will result in the value itself.
  ```java
      /**
        * Find Unique number in an array using Bitwise XOR operator.
        * TC: O(n)
        * SC: O(1)
        *
        * @param nums
        * @return
        */
        public static int findSingleNumberBitwiseXor(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = res ^ nums[i];
            }
            return res;
        }
  ```