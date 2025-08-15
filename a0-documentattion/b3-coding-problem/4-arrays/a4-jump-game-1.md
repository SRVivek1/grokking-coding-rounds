# [Leetcode Q55 (Medium):](https://leetcode.com/problems/jump-game/description/) Jump Game 1

## Problem statements:
  - You are given an integer array $nums$. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
  - Return ***true*** if you can reach the last index, or ***false*** otherwise.

<br/>

  - **Constraints:** 
    - 1 <= nums.length <= $10^4$
    - 0 <= nums[i] <= $10^5$

<br/>

- **Examples:**
  - **Example 1:**
    - Input: nums = [2,3,1,1,4]
    - Output: true
    - **Explanation:** 
      - Jump 1 step from index 0 to 1, then 3 steps to the last index.
  
  <br/>

  - **Example 2:**
    - Input: nums = [3,2,1,0,4]
    - Output: false
    - **Explanation:** 
      - You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

<br/>

## Problem Analysis:
  - The problem, "Jump Game," asks whether you can reach the last index of an array given a set of jump lengths. 
    - You start at the first index, and each element nums[i] represents the maximum length of a jump you can make from that position. 
    - The goal is to determine if it's possible to get to the very last index.

<br/>

- **For example:** $nums = [2, 3, 1, 1, 4]$
  - From index 0, 
    - you can jump a maximum of 2 steps, reaching index 1 or 2.
  - From index 1, 
    - you can jump a maximum of 3 steps, reaching index 2, 3, or 4.
  - Since we can reach index 4, which is the last index, the ***answer is true***.

- **Another example:** $nums = [3, 2, 1, 0, 4]$
  - From index 0, 
    - you can jump up to 3 steps, reaching index 1, 2, or 3.
  - From index 1, 
    - you can jump up to 2 steps.
  - From index 2, 
    - you can jump up to 1 step.
  - From index 3, 
    - you can only jump 0 steps, ***so you're stuck***.
  - Since we get stuck at index 3 and cannot reach the last index, ***the answer is false***.

<br/>

### Edge Cases:
  - **Empty or Single-Element Array:** 
    - If the array is empty or has only one element, you're already at the end. ***The answer is true***. 
    - The problem statement typically specifies a non-empty array, but it's good to consider this.

  - **Zero at the Beginning:** 
    - If $nums[0] == 0$ and the array has more than one element, you can't move at all. The ***answer is false***.

  - **Zeroes in the Middle:** 
    - A zero can be a major hurdle. The key is whether you can jump over a zero. 
      - If you reach an index i where nums[i] == 0, you must have been able to jump to i from an earlier position j such that j + nums[j] > i.

  - **Array with all ones:** 
    - If all element values are $1$, that is $nums = [1, 1, 1, ..., 1]$. You can always make a single step jump to the end. Hence, The ***answer is true***.

<br/>

## Solutions:

### Brute-Force Approach (Recursion with Backtracking):
  - The most intuitive way to solve this is to explore all possible jump paths. 
    - We can use a recursive function that starts at index 0 and tries every possible jump from the current position. 
    - If a jump leads to the last index, we've found a solution and can return true. 
    - If we try all jumps from a position and none lead to a solution, we backtrack.

<br/>

- **Algorithm:**
  - **Recursive Function:**
    - Define a recursive function, let's say canJump(index).

  - **Base case:** 
    - If $index >= len(nums) - 1$, we've reached or passed the end. 
    - Hence ***return true***.

- **Recursive step:**
  - Get the maximum jump length from the current index, $maxJump = nums[index]$.
  - Loop from 1 to max_jump. For each step s:
    - Recursively call canJump(index + s).
    - If the recursive call returns true, then we've found a valid path, ***return true immediately***.
  - If the loop finishes without finding a valid path, ***return false***.

<br/>

- **Complexity:**
  - **Time Complexity:** 
    - The time complexity is **exponential**, as we are exploring a tree of possibilities. 
    - Many subproblems are re-evaluated, like checking if we can reach index 3 from both index 1 and index 2. This can be optimized with memoization. $O(2^{\mathrm{n}})$.

  - **Space Complexity:** 
    - $O(n)$ due to the recursion depth.

<br/>

### Optimized Approach (Greedy Algorithm)
  - A much more efficient approach is to use a greedy algorithm. Instead of trying to find a path to the end, let's think about the problem in reverse. What's the "safest" or "last reachable" position we need to be in to reach the end?

  - Let's maintain a variable, goal, representing the target position we need to reach. Initially, this is the last index of the array, n - 1. We then iterate backward from the second-to-last element to the beginning.

  - For each index i, we check if it's possible to reach our goal from i. 
    - A jump from i can reach goal if i + nums[i] >= goal. If this condition is met, it means we can now consider i as our new, closer goal, because we've proven that we can reach the original goal from i. 
    - We then update goal = i. We continue this process until we reach the beginning of the array.

  - If, after checking all positions, our goal has been updated to 0, it means we've found a path from the starting index (0) to the original goal. 
    - Otherwise, it's not possible.


<br/>

  - **Algorithm:**
    - Initialize a variable goal to the index of the last element: $goal = nums.length - 1$.
    - Iterate backward through the array from $len(nums) - 2$ down to $0$.

    - **For each index i**:
      - Check if $i + nums[i]$ is greater than or equal to goal.
        - If it is, this means we can reach the current goal from this position i. 
        - We now have a new, closer goal. So update $goal = i$.
    - After the loop, check if $goal == 0$.
      - If it is, return ***true***.
      - Otherwise, return ***false***.


<br/>

  - **Complexity:**
    - **Time Complexity:**
      - We perform a single pass through the array. This is a linear operation $O(n)$. 
  - **Space Complexity:** 
    - We use a constant amount of extra space for the goal variable. $O(1)$.

#### Java Implemention 1 - Reverse tracking:

```java
    /**
     * This algo starts from last index and checks if we can there's any index + value combination >= target index value.
     * If yes change target index to current index and now resolve the same problem from current index.
     * @param arr
     * @return
     */
    public boolean canJumpSol2(int[] arr) {

        // we can not iterate null or empty array
        if(arr == null || arr.length == 0) return false;

        int goal = arr.length - 1;

        // check if we can reach to last index from 2nd last index to 0th index
        for(int i = arr.length - 2; i >= 0; i--) {
            
            // calculate maximum jump possible from 2nd last index
            int jump = i + arr[i];
            
            if(jump >= goal) {
                // Greedy algo - now consider current index as goal and check if it's reachable
                goal = i;
            }
        }

        // if goal is 0 means we reach 0th index and hence true.
        return goal == 0;
    }

```

<br/>

#### Java Implemention 2 - Checking from index 0:
```java
    /**
     * Determines if it's possible to reach the last index of the array by jumping.
     *
     * This greedy algorithm iterates forward from the start of the array,
     * tracking the farthest index that can be reached at any given point.
     *
     * @param arr The array where each element represents the maximum jump length.
     * @return {@code true} if the last index is reachable, {@code false} otherwise.
     */
    public boolean canJumpSol1(int[] arr) {
        // Edge case: A null or empty array is considered un-jumpable.
        // Note:, a single-element array is always reachable.
        if (arr == null || arr.length == 0) {
            return false;
        }

        // `maxReachable` stores the farthest index we can currently reach.
        int maxReachable = 0;

        for (int i = 0; i < arr.length; i++) {
            // If the current index `i` is beyond what we can reach,
            // it means we're stuck and cannot proceed.
            if (i > maxReachable) {
                return false;
            }

            // Update the farthest reachable index. We take the maximum
            // of the current `maxReachable` and the new potential reach
            // from our current position (`i + arr[i]`).
            maxReachable = Math.max(maxReachable, i + arr[i]);

            // If the farthest reachable index is at or past the end of the array,
            // we've found a valid path.
            if (maxReachable >= arr.length - 1) {
                return true;
            }
        }

        // If the loop completes without reaching the last index,
        // it means a path does not exist.
        return false;
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
