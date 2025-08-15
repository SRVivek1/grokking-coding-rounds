# [Leetcode Q189 (Medium):](https://leetcode.com/problems/rotate-array/description/) Rotate Array K times

## Problem statements:
- Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

<br/>

  - **Constraints:** 
    - 1 <= nums.length <= 105
    - -231 <= nums[i] <= 231 - 1
    - 0 <= k <= 105

<br/>

- **Examples:**
  - **Example 1:**
    - Input: nums = [1,2,3,4,5,6,7], k = 3
    - Output: [5,6,7,1,2,3,4]
    - Explanation:
    - rotate 1 steps to the right: [7,1,2,3,4,5,6]
    - rotate 2 steps to the right: [6,7,1,2,3,4,5]
    - rotate 3 steps to the right: [5,6,7,1,2,3,4]
  
  <br/>

  - **Example 2:**
    - Input: nums = [-1,-100,3,99], k = 2
    - Output: [3,99,-1,-100]
    - Explanation: 
    - rotate 1 steps to the right: [99,-1,-100,3]
    - rotate 2 steps to the right: [3,99,-1,-100]

<br/>

## Problem Analysis:
  - The problem, commonly known as Rotate Array, asks us to rotate a given integer array nums to the right by $k$ steps. 
  - The rotation should be done in-place, meaning we should modify the original array without creating a new one. 
  - $k$ is a non-negative integer.

<br/>

 - **Let's consider an example:**
    - nums = [1, 2, 3, 4, 5, 6, 7] and k = 3.
      - After $1^{\mathrm{st}}$ rotaion: $[7, 1, 2, 3, 4, 5, 6]$
      - After $2^{\mathrm{nd}}$ rotaion: $[6, 7, 1, 2, 3, 4, 5]$
      - After $3^{\mathrm{rd}}$ rotaion: $[5, 6, 7, 1, 2, 3, 4]$
    - The final result should be $[5, 6, 7, 1, 2, 3, 4]$.

<br/>

### Edge Cases:
  - **Empty array or single-element array:** 
    - If nums is empty or has only one element, ***no rotation is needed***.

  - **k is a multiple of the array length:** 
    - If k is a multiple of n (the length of nums), the array will return to its original state. 
      - **For example,** if $n=7$ and $k=7$, the array remains unchanged. 
    - We can handle this by using ***k = k % n*** to find the ***effective number of rotations***.

  - **Large k value:** 
    - The value of $k$ can be larger than the array size. 
      - **For example**, $n=3$, $k=5$. Rotating by 5 is the same as rotating by 2 (5 % 3 = 2). 
    - The ***modulo operator*** (%) is crucial here.

  - **k is 0:** 
    - If $k$ is $0$, no rotation is needed. 
    - The ***modulo operation k % n*** will handle this correctly as well.

<br/>

## Solutions:

### Brute-Force Approach (Iterative Rotation):

- **Concept:**
  - The most straight forward way is to rotate the array one step at a time, k times. 
  - In each step, we move the last element to the front and shift all other elements one position to the right.

<br/>

- **Algorithm:**
  - **Effective Number of Rotation:**
    - Calculate the effective number of rotations by ***k = k % n***, where $n$ is the length of input array.

  - **Repeat k times:**
    - **Step-1:** 
      - Store the last element of the array in a temporary variable, let's call it lastElement.
    - **Step-2:** 
      - Shift all elements from index $n-2$ down to $0$ one position to the right. 
      - That is, $nums[j+1] = nums[j]$ for $j$ from $n-2$ down to $0$.
    - **Step-3:** 
      - Place last_element at the beginning of the array, $nums[0] = lastElement$.

<br/>

- **Complexity Analysis:**
  - **Time Complexity:**
    - We perform an $O**(n)$ operation** 
    (shifting elements) $k$ times. 
    - Hence, the time complexity is $O(k * n)$. This can be ***inefficient*** if $k$ and $n$ are large.

  - **Space Complexity:** 
    - We only use a single temporary variable to store the last element, so the space complexity is $O(1)$.

<br/>

### Optimized Approach (The Three-Reversal Method)

- **Concept:**
  - This is a clever and ***efficient in-place method***. 
  - The key insight is that rotating an array can be achieved by reversing specific segments of the array. 
  - **The algorithm works in three steps:**
    - Reverse the entire array.
    - Reverse the first k elements.
    - Reverse the remaining n-k elements.
  - **Example:**
    - Let's trace this with nums = [1, 2, 3, 4, 5, 6, 7] and k = 3.
      - Reverse the whole array: [7, 6, 5, 4, 3, 2, 1]
      - Reverse the first k elements (first 3): [5, 6, 7, 4, 3, 2, 1]
      - Reverse the rest (n-k elements, from index 3 to 6): [5, 6, 7, 1, 2, 3, 4]
    - The result matches the required output. 
  - **This method works because,**
    - Reversing the whole array brings the last k elements to the front in reverse order. 
    - Reversing the first k elements corrects their order. 
    - Finally, reversing the remaining elements restores their original relative order.

<br/>

- **Algorithm:**
  - **Effective Number of Rotation:** 
    - Calculate the effective number of rotations: k = k % n.
  - **Reverse array function:**
    - Define a helper function, say reverse(arr, start, end), that reverses the elements of the array arr from provided start to end indexes (inclusive).
  - **Reverse complete array:**
    - Call *reverse(nums, 0, n-1)* to reverse the entire array.
  - **Reerse first k Elements:**
    - Call *reverse(nums, 0, k-1)* to reverse the first k elements.
  - **Reverse remaining n-k elements:**
    - Call *reverse(nums, k, n-1)* to reverse the remaining n-k elements.

<br/>

- **Complexity Anlysis:**
  - **Time Complexity:**
    - Each reversal operation takes $O(n)$ time. 
    - Since we perform 3 such operations, the total time complexity is $O(3n)$, which is equal to $O(n)$. 
    - This is much better than the brute-force approach, especially for large k. 
  - **Space Complexity:** 
    - The reversal is done in-place, so the space complexity is $O(1)$.

#### Implemention - Java:

```java
    /**
     * Rotates an array to the right by k steps.
     * The rotation is performed in-place.
     *
     * @param nums The array of integers to be rotated.
     * @param k The number of steps to rotate the array to the right.
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        // Use the modulo operator to handle cases where k is greater than the array length.
        // This ensures k is always within the range [0, n-1].
        k %= n;

        // Step 1: Reverse the entire array.
        // For example, [1, 2, 3, 4, 5, 6, 7] becomes [7, 6, 5, 4, 3, 2, 1].
        reverse(nums, 0, n - 1);
        
        // Step 2: Reverse the first k elements.
        // For k=3, [7, 6, 5, 4, 3, 2, 1] becomes [5, 6, 7, 4, 3, 2, 1].
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining n-k elements.
        // [5, 6, 7, 4, 3, 2, 1] becomes [5, 6, 7, 1, 2, 3, 4].
        reverse(nums, k, n - 1);
    }


    /**
     * A helper method to reverse a portion of an array.
     *
     * @param nums The array.
     * @param start The starting index of the portion to reverse.
     * @param end The ending index of the portion to reverse.
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

```

<br/>

#### Implementtion: Python
```python
    class Solution:
      def rotate(self, nums: list[int], k: int) -> None:
          """
          Do not return anything, modify nums in-place instead.
          """
          n = len(nums)
          if n == 0:
              return

          k %= n

          def reverse(arr, start, end):
              while start < end:
                  arr[start], arr[end] = arr[end], arr[start]
                  start += 1
                  end -= 1

          # Step 1: Reverse the entire array
          reverse(nums, 0, n - 1)
          # Step 2: Reverse the first k elements
          reverse(nums, 0, k - 1)
          # Step 3: Reverse the remaining n-k elements
          reverse(nums, k, n - 1)
```


---
<center>
<h3> ------ End ------ </h3>
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
