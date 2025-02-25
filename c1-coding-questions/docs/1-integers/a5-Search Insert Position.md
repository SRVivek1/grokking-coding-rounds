# Integers: Search Insert Position
## Problem statements: [leetcode-35](https://leetcode.com/problems/search-insert-position/description/)

- Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  - You must write an algorithm with O(log n) runtime complexity.

- **Example 1:**
  - **Input:** nums = [1,3,5,6], target = 5
  - **Output:** 2

- **Example 2:**
  - **Input:** nums = [1,3,5,6], target = 2
  - **Output:** 1

- **Example 3:**
  - **Input:** nums = [1,3,5,6], target = 7
  - **Output:** 4
 
**Constraints:**
  - *1 <= nums.length <= 104*
  - *-104 <= nums[i] <= 104*
  - *nums contains distinct values sorted in ascending order.*
  - *-104 <= target <= 104*


## Soltuions:
### 1. Binary Search Approach
  - Perform binary search on the input array for target value.
  - If element is found:
    - Return the element index.
  - If element is not found:
    - Check if target is greater than mid, then it will lie on right side of mid.
      - Hence return ***mid + 1*** index.
    - Check if target is smaller than mid, then it will lie on left side of mid.
      - Hence return ***mid*** index.

  - **Logic:**
    - TBU

  - **Implementation: Recurssion**
    - **Note:** Recussion approach has one drawback that it uses Stack memory for recursive calls.
    ```java
            public int searchInsert(int[] nums, int target) {
                return search(nums, 0, nums.length - 1, target);
            }

            /**
             * Perform binary search to check for target element and determine the insertion positions if missing.
            * 
            */
            public int search(int[] nums, int start, int end, int target) {

                int mid = start + (end - start) / 2;

                // insertion position
                if (start >= end) {
                    if (target > nums[mid]) {
                        return mid + 1;
                    } else if (target < nums[mid]) {
                        return mid;
                    }
                }

                if (nums[mid] == target) {
                    return mid;
                }

                if (target > nums[mid]) {
                    return search(nums, mid + 1, end, target);
                }

                if (target < nums[mid]) {
                    return search(nums, start, mid - 1, target);
                }

                return -1;
            }
    ```

  - **Implementation: whhile loop**
    - Advance on execution time and space complexity.
    - ***+10%*** efficient on leetcode compared to recursion.
    ```java
        public int searchInsert(int[] nums, int target) {
            return search(nums, 0, nums.length - 1, target);
        }
        
        /**
         * Binary search using loop.
         */
        public int searchloop(int[] nums, int target) {

        int start = 0, end = nums.length -1; 
        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            }
        }
        if(target <= nums[start]) {
            return start;
        } else {
            return start + 1;
        }
    }
    ```

---
<center>
<h1> ------ End ------ </h1>
</center>

<!-- HTML styling -->
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
heading {
  color: blue;
  font-size: 20px;
  }
</style>