# [Leetcode Q238 (Medium):](https://leetcode.com/problems/product-of-array-except-self/) Product of Array Except Self

## Problem statements:
  - Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
  - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
  - You must write an algorithm that runs in O(n) time and without using the division operation.

<br/>

  - **Constraints:** 
    - 2 <= nums.length <= 105
    - -30 <= nums[i] <= 30
    - The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

<br/>

- **Examples:**
  - **Example 1:**
    - Input: nums = [1,2,3,4]
    - Output: [24,12,8,6]
  
  <br/>

  - **Example 2:**
    - Input: nums = [-1,1,0,-3,3]
    - Output: [0,0,9,0,0]

<br/>

**Follow up:** 
  - Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

<hr/>

## Problem Analysis:
  - The problem asks us to compute an array answer where answer[i] is the product of all elements in the input array nums except for nums[i]. 
  - We must solve this without using the division operator and in O(n) time complexity. 
  - An additional challenge is to achieve O(1) extra space complexity, where the output array does not count towards the space.

<hr/>

### Edge Cases:
  - **Zeros in the array:**
    - **One zero:** 
      - If nums contains a single zero, say at index k, then answer[k] will be the product of all non-zero elements. 
      - For all other indices i, answer[i] will be 0, as the product of all elements except nums[i] will include the zero.

    - **Multiple zeros:** 
      - If nums contains two or more zeros, the product of all elements is 0. 
      - Consequently, the product of all elements except any single one will also be 0. Thus, all elements in the answer array will be 0.

  - **Negative numbers:** 
    - The approach must correctly handle negative numbers. The resulting product at each index could be positive or negative.

  - **Constraints:** 
    - The problem states the array length is at least 2, so we don't need to worry about a single-element array.


<hr/>

## Solutions:

### Brute-Force Approach (Nested loop):
  - A straightforward solution is to iterate through the array, and for each element at index i, iterate again to calculate the product of all other elements.

<br/>

- **Algorithm:**
  - Initialize an empty result array answer of the same size as nums.
  - Iterate $i$ from $0$ to n-1.
    - For each $i$, initialize a current_product = 1.
    - Iterate $j$ from 0 to n-1.
    - If $i$ is not equal to $j$, multiply current_product by nums[j].
    - Store current_product in answer[i].
  - Return answer.

<br/>

- **Complexity:**
  - **Time Complexity:** 
    - The nested loops result in a time complexity of $O(n^2)$.
    - It is not optimal and fails the $O(n)$ constraint.

  - **Space Complexity:** 
    - $O(n)$ for the result array.

<hr/>


### Optimized Approach (Prefix and Suffix Products)
  - The core idea is to precompute the products of elements to the left of each index and the products of elements to the right of each index. 
  - The product for a given index $i$ is then simply the product of its left and right segments.


<br/>

  - **Algorithm:**
    - Initialize 3 arrays of size $n$: left_products, right_products, and answer.

    - **Left Products Pass:**
      - Set left_products[0] = 1.
      - Iterate from $i = 1$ to $n-1$: 
        - left_products[i] = left_products[i-1] * nums[i-1].
      - **Note:** 
        - After this loop, left_products[i] holds the product of all elements to the left of nums[i].

    - **Right Products Pass:**
      - Set right_products[n-1] = 1.
      - Iterate from $i = n-2$ down to $0$: 
        - right_products[i] = right_products[i+1] * nums[i+1].
      - **Note:**
        - After this loop, right_products[i] holds the product of all elements to the right of nums[i].

    - **Final Product Pass:**
      - Iterate from $i = 0$ to $n-1$: 
        - answer[i] = left_products[i] * right_products[i].

    - Return answer array.

<br/>

  - **Complexity:**
    - **Time Complexity:**
      - Three separate passes through the array, each taking $O(n)$ time. So, total time complexity is $O(3n)$ which will be $O(n)$. 
  - **Space Complexity:** 
      - We use two additional arrays of size $n$, so the space complexity is O(2n), ignoring constants it will be $O(n)$.

<hr/>

### Most Optimized Approach: O(1) Extra Space
  - We can optimize the space complexity by reusing the output array to store the prefix products and then calculating the suffix products in a single pass while populating the final result.

<br/>

  - **Algorithm:**
    - Initialize an array answer of size n.
    - **First Pass (Prefix Products):**
      - Set answer[0] = 1.
      - Iterate from i = 1 to n-1: 
        - answer[i] = answer[i-1] * nums[i-1].
      - **Note:** 
        - At the end of this loop, answer[i] contains the product of all elements to the left of nums[i].
 
    - **Second Pass (Suffix Products):**
      - Initialize a variable right_product = 1.
      - Iterate from i = n-1 down to 0:
        - Update answer[i] by multiplying its current value (the left product) with right_product.
        - Update right_product by multiplying it with nums[i] for the next iteration.

    - Return answer array.

<br/>

  - **Complexity:**
    - **Time Complexity:**
      - Two passes through the array, resulting in a total time complexity of $O(n)$. 
  - **Space Complexity:** 
      - We only use a single variable right_product in addition to the output array. 
      - The problem statement allows the output array to not be counted as extra space. 
      - Thus, the space complexity is $O(1)$. This is the optimal solution.

<hr/>


#### Java Implemention 1 - Optimized Approach (Prefix and Suffix Products):

```java
    public int[] productExceptSelf(int[] nums) {
        
        // Handle edge cases for an empty or null input array.
        // Although the problem guarantees nums.length >= 2, this is robust practice.
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] prefixProducts = new int[n];
        int[] suffixProducts = new int[n];
        int[] result = new int[n];

        // First pass: Populate the prefixProducts array.
        // prefixProducts[i] stores the product of all elements to the left of index i.
        prefixProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // Second pass: Populate the suffixProducts array.
        // suffixProducts[i] stores the product of all elements to the right of index i.
        suffixProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }

        // Third pass: Combine the prefix and suffix products to get the final result.
        // The product of all elements except nums[i] is the product of elements to its left
        // and the product of elements to its right.
        for (int i = 0; i < n; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
```

<br/>
<hr/>

#### Java Implemention - Most Optimized Approach: O(1) Extra Space:

```java
    public int[] productExceptSelf(int[] nums) {
        
        // Handle edge case where the input array is null or empty.
        // Although the problem constraints state nums.length >= 2, this is a good practice.
        if(nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] res = new int[n];

        // First pass: Calculate prefix products and store them in the result array.
        // res[i] will hold the product of all elements to the left of nums[i].
        // For the first element, there are no elements to its left, so the product is 1.
        res[0] = 1;
        for(int i = 0; i < n - 1; i++) {
            res[i+1] = nums[i] * res[i];
        }
        
        // Second pass: Calculate suffix products and combine with the prefix products.
        // `sp` (suffix product) keeps track of the product of elements to the right of the current index.
        int sp = 1;

        for(int i = n - 1; i >= 0; i--) {
            // Multiply the current prefix product (in res[i]) with the suffix product.
            // This gives the product of all elements except nums[i].
            res[i] = res[i] * sp;
            // Update the suffix product for the next iteration.
            sp *= nums[i];
        }

        return res;
    }
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
