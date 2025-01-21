# Static and Dynamic Arrays
## 1. Introduction

- **<ins>Data Structure</ins>**
  - The main difference between static and dynamic arrays is the size of the array, which can be fixed or flexible. 
  - **Static arrays:**
    - A fixed length container (continious chunk of memory) containing *n* elements indexable from the raneg [0, n-1]. Array indexes are zero-based that is first index of an Array is `0`.
    - Indexable means that each slot/index in the array can be referenced with a number.
    - It's fixed in size once created cannot be resized.
    - They are ***constructed on the stack***.
    - They are automatically deleted when they go out of scope.
    - **Use cases:**
      - Storing and accessing sequential data.
      - Temproarily storing objects.
      - Used by IO Routines as buffer.
      - Lookup tables and inverse lookup tables (because arrays are indexable)
      - Can be used to return multiple values from a function
      - Used in *Dynamic programming* to cache answers to subproblesm.

  - **Dynamic arrays**
    - Thease can grow and shrink in size.
    - They are ***constructed on the heap***.
    - **Implementation:**
      - *Using static arrays*
        - Create a static array with initial capacity.
        - Add elements to underlying static array, keeping the track of the number of elements.
        - If adding another element will exceed the capacity, then create a new static array of twice the capacity and copy the original elements into it.

- **Time Complexility**

| Operation | Static Array | Dynamic Array |
| --------- | ------------ | ------------- |
| Access    | O(1) | O(1) | 
| Search    | O(n) | O(n) |
| Insertion | N/A  | O(n) |
| Appending | N/A  | O(1) |
| Deletion  | N/A  | O(n) |


- **Implementation:**
  - ***Step-1:***
    - Create Following variables:
      - An array to store data
      - A variable to store array capacity
      - A variable to store count (length) of elements.
  - ***Step-2:***
    - While adding elements check if *lenght + 1* is greater than capicity.
    - Create a new Array and copy all elements then add new elements.
  - ***Step-3:***
    - Implement other methods accordingly.
  
  - Check below link for complete implementation of Custom Dynamic Array.
    - [DynamicArray.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/arrays/dynamic/DynamicArray.java)

- **<ins>References:</ins>**
  - [https://www.youtube.com/watch?v=RBSGKlAvoiM](https://www.youtube.com/watch?v=RBSGKlAvoiM)
---
<center>
<h1> ------ End ------ </h1>
</center>

---
<!-- HTML styling -->
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>