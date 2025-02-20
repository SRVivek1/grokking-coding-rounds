# Integers: Find the only two unique number in an array
## Problem statements:
- Given a non-empty array of integers `nums` every element appears twice except for two numbers. 
- Find those unique integer values.
- Constraints:
  - The solution should have linear time complexity : O(n).
  - Space complexity should be O(1).

- Example 1:
  - **Input:** `nums = [2,4,7,9,2,4]`
  - **Output:** `[7,9]`

- Example 2:
  - **Input:** `nums = [4,1,2,1,14,2]`
  - **Output:** `[4,14]`

- Example 3:
  - **Input:** `nums = [1,3]`
  - **Output:** `[1,3]`

## Soltuions:
### 1. Bitwise XOR
  - **Approach:**
    - *Step-1:* Filter the duplicates, result will be XOR of unique numbers.
    - *Step-2:* Find the right most set bit using XOR result.
    - *Step-3:* Now filter numbers in 2 groups:
      - 1st who has rightmost bit set.
      - 2nd where the rightmost bit is not set.
    - Step-4: Now at this stage we have two group of numbers where each group has 1 unique number in it.
      - Apply XOR operation to filter the unique numbers from each group.

  ```java
      /**
        * Find the 2 unique numbers in the array of duplicates.
        *
        * @param nums input array
        * @return result array
        */
        public static int[] findUniqueNumbers(int[] nums) {
            int[] res = new int[2];

            // Step - 1 : Find XOR of the 2 unique numbers
            int xors = 0;
            for (int num : nums) {
                xors ^= num;
            }

            // step-2: Find the right most set bit
            int rightMostSetBit = xors & (-xors);

            // step-3: filter both unique values
            // Approach: In the given unique number only one have right bit set '1'
            for (int num : nums) {
                if ((num & rightMostSetBit) != 0) {
                    res[0] ^= num;
                } else {
                    res[1] ^= num;
                }
            }
            return res;
        }
      
      // Driver program
      public static void main(String[] args) {
          int[] inp1 = {1, 4};
          int[] inp2 = {1, 2, 4, 5, 7, 9, 1, 2, 4, 5};
          int[] inp3 = {7, 2, 4, 5, 2, 4, 5, 15};

          print(inp1);
          int[] res = findUniqueNumbers(inp1);
          print(res);

          print(inp2);
          res = findUniqueNumbers(inp2);
          print(res);

          print(inp3);
          res = findUniqueNumbers(inp3);
          print(res);

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