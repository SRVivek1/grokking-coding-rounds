# LeetCode: Find Minimum in Rotated Sorted Array
## Problem statements:
<!-- - [Leetcode-N/A](https://leetcode.com/problems/find-maximum-in-rotated-sorted-array/description/) [*Difficulty: Medium*] -->
  - Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
  - For example, the array nums = [0,1,2,4,5,6,7] might become:
    - [4,5,6,7,0,1,2] if it was rotated 4 times.
    - [0,1,2,4,5,6,7] if it was rotated 7 times.
  - Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

  - Given the sorted rotated array nums of unique elements, return the maximum element of this array.
  - You must write an algorithm that runs in O(log n) time.
 
### Examples:

  - **Example 1:**
    - ***Input:*** nums = [3,4,5,1,2]
    - ***output:*** 5
    - ***Explanation:*** The original array was [1,2,3,4,5] rotated 3 times.
  
  - ***Example 2:***
    - ***Input:*** nums = [4,5,6,7,0,1,2]
    - ***output:*** 7

  - ***Example 3:***
    - ***Input:*** nums = [11,13,15,17]
    - ***output:*** 17


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
  - Since we need a time complexity of O(log n), we will use binary search. 
  - The key idea is to compare the middle element with the rightmost element.

  - ***Steps:***
    - **Initialization:**
      - Set left to **0** and right to ***nums.length - 1***.
    - **Binary Search:**
      - While left < right:
      - **Calculate the middle index:** 
        - mid = left + (right - left) / 2.
      - Check the highest value near to mid:
        - *mid < r && arr[mid] > arr[mid + 1]*, then arr[mid] is the highest value.
        - *mid > l && arr[mid] < arr[mid - 1]*, then arr[mid - 1] is the highest value.
      - if above condition not satisfied, divide the array and check for the value:
        - *arr[mid] < arr[l]* then highest value is in left part, *r = mid - 1*
        - Otherwise check in right part, *l = mid + 1*.
    - **Result:** 
      - When the loop terminates, left will be pointing to the maximum element. 
        - Return ***nums[left]***.

## Solution: 
### Solution-1: Modified Binary Search Algo.
  ```java
      public int findMax(int[] arr) {
          if(arr == null || arr.length == 0) 
              throw new ArrayIndexOutOfBoundsException("Null / Empty array");
          if(arr.length == 1 || arr[0] <= arr[arr.length - 1]) return arr[arr.length - 1];

          int l = 0, r = arr.length - 1;

          while(l < r) {
              int mid = l + (r - l) / 2;

              // check the highest element near to mid
              if(mid < r && arr[mid] > arr[mid + 1]) return arr[mid];
              if(mid > l && arr[mid] < arr[mid - 1]) return arr[mid - 1];

              if(arr[mid] < arr[l]) r = mid - 1;
              else l = mid + 1;
          }
          return arr[l];
      }
  ```

  ### Solution-2: Modified Binary Search Algo.
  ```java
      public int findMax(int[] arr) {
          if (arr == null || arr.length == 0) return -1;
          if (arr.length == 1) return arr[0];
          if (arr[0] < arr[arr.length - 1]) return arr[arr.length - 1];

          int l = 0, r = arr.length - 1;

          /*
          * Modified binary search to find the maximum element in the rotated
          * sorted array.
          */
          while (l < r) {
              int m = l + (r - l) / 2;

              if (arr[m] > arr[r]) l = m + 1;
              else r = m;
          }

          return arr[l - 1];
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
