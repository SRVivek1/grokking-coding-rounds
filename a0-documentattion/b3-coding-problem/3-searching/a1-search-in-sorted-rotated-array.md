# LeetCode: Search in Sorted Rotate Array
## Problem statements:
- [Leetcode-33](https://leetcode.com/problems/search-in-rotated-sorted-array/description//) [*Difficulty: Medium*]
  - There is an integer array nums sorted in ascending order (with distinct values).
  - Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
  - Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
  - You must write an algorithm with O(log n) runtime complexity.

 
### Examples:

  - **Example 1:**
    - ***Input:*** nums = [4,5,6,7,0,1,2], target = 0
    - ***output:*** 4
  
  - ***Example 2:***
    - ***Input:*** nums = [4,5,6,7,0,1,2], target = 3
    - ***output:*** -1

  - ***Example 3:***
    - ***Input:*** nums = [1], target = 0
    - ***output:*** -1


### Constraints:
  - 1 <= nums.length <= 5000
  - -104 <= nums[i] <= 104
  - All values of nums are unique.
  - nums is an ascending array that is possibly rotated.
  - -104 <= target <= 104


## Edge cases to consider
  - Single element array → [1], target present and absent.
  - Already sorted array (no rotation) → [1, 2, 3, 4, 5], target at start, middle, or end.
  - Rotation at different points → [3,4,5,1,2], [5,1,2,3,4], etc.
  - Target not in array → Must return -1.
  - Target is pivot → Ensure correct index is returned.
  - Even and odd length arrays → [3,4,5,1,2] (odd), [4,5,6,7,0,1,2,3] (even).
  

## Solution Approach: *(Binary Search - O(log n), O(1) space)*
  - Since we need ***O(log n)*** time, a ***binary search approach*** is ideal.
  - ***We can exploit the property of the rotated sorted array:***
    - *One half of the array (either left or right) is always sorted.*
    - *If target lies in the sorted half, do a normal binary search.*
    - *Otherwise, search in the unsorted half where rotation exists.*

  - ***Steps:***
    - **Initialize pointers:** 
      - *left = 0, right = n - 1*
    - **Binary Search Loop (while left <= right):**
      - **Calculate middle index:**
        - mid = (left + right) / 2
        - If nums[mid] == target, return mid (index) value.
      - **Identify the sorted half:**
        - Left half is sorted, if:
          - *If nums[left] ≤ nums[mid]* → 
      - If target is in range [nums[left], nums[mid]], search in left (right = mid - 1)
        - Else, search right (left = mid + 1)
      - **Or else, Right half is sorted:**
      - If target is in range [nums[mid], nums[right]], search in right (left = mid + 1)
        - Else, search left (right = mid - 1)
    - If not found, return -1.

## Solution: 
### Solution: Modified Binary Search Algo.
  ```java
      public int search(int[] nums, int target) {  
         int l = 0, r = nums.length - 
         while(l <= r) {
             int mid = l + (r -l) / 2;
             if(nums[mid] == target) return m 
             if(nums[l] <= nums[mid]) {
                 if(target >= nums[l] && target < nums[mid]) {
                     r = mid - 1;
                 } else {
                     l = mid + 1;
                 }
             }  else {
                 if(target > nums[mid] && target <= nums[r]){
                     l = mid + 1;
                 } else {
                     r = mid - 1;
                 }
             }
         }
         return -1;
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
