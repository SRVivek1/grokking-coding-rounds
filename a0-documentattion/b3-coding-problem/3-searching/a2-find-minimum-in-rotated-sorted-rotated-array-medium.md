# LeetCode: Find Minimum in Rotated Sorted Array
## Problem statements:
- [Leetcode-153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/) [*Difficulty: Medium*]
  - Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
  - For example, the array nums = [0,1,2,4,5,6,7] might become:
    - [4,5,6,7,0,1,2] if it was rotated 4 times.
    - [0,1,2,4,5,6,7] if it was rotated 7 times.
  - Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

  - Given the sorted rotated array nums of unique elements, return the minimum element of this array.
  - You must write an algorithm that runs in O(log n) time.
 
### Examples:

  - **Example 1:**
    - ***Input:*** nums = [3,4,5,1,2]
    - ***output:*** 1
    - ***Explanation:*** The original array was [1,2,3,4,5] rotated 3 times.
  
  - ***Example 2:***
    - ***Input:*** nums = [4,5,6,7,0,1,2]
    - ***output:*** 0

  - ***Example 3:***
    - ***Input:*** nums = [11,13,15,17]
    - ***output:*** 11


### Constraints:
  - n == nums.length
  - 1 <= n <= 5000
  - -5000 <= nums[i] <= 5000
  - All the integers of nums are unique.
  - nums is sorted and rotated between 1 and n times.


## Edge cases to consider
  - **Empty Array:** 
    - If the input array is empty, we should handle this gracefully (e.g., throw an exception or return a special value).
  - **No Rotation:** 
    - If the array is not rotated (i.e., it's still in ascending order), the minimum element is simply the first element.
  - **Single Element Array:**
    - If the array contains only one element, that element is the minimum.
  - **All elements are same:** 
    - If all elements are same, then we can find the minimum by simply returning the first element.
  

## Solution Approach: *(Binary Search - O(log n), O(1) space)*
  - Since we need a time complexity of O(log n), we can use binary search. 
  - The key idea is to compare the middle element with the rightmost element.

  - ***Steps:***
    - **Initialization:**
      - Set left to 0 and right to nums.length - 1.
    - **Binary Search:**
      - While left < right:
      - **Calculate the middle index:** 
        - mid = left + (right - left) / 2.
      - If nums[mid] > nums[right], 
        - it means the minimum element is in the right half of the array. 
          - So, update ***left = mid + 1***.
      - Otherwise, the minimum element is in the left half or at mid. 
        - So, update ***right = mid***.
    - **Result:** 
      - When the loop terminates, left and right will point to the minimum element. 
        - Return ***nums[left]***.

## Solution: 
### Solution: Modified Binary Search Algo.
  ```java
      public int findMinimum(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if(arr[0] < arr[arr.length - 1]) return arr[0];

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if(arr[mid] < arr[r]) r = mid;
            else l = mid + 1;
        }
        // At the end, l == r and points to the minimum element
        return arr[l];
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
