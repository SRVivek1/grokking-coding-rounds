# Hash-table Data Structure
## 1. Introduction

- **<heading>Hash-table DS</heading>**
  - A *Hash table* is a Data Structure that provides a mapping from key to values using a technique called ***hashing***. Hashing means a Hash function is used to compute an index (or hash code) for a given key, determining where the value should be stored in an array.
    - Which help for efficient insertion, deletion, and lookup operations, typically in $O(1)$ average time complexity.
  - The data is stored as key-value pairs hence key must be unique but no restrictions for values, they can be duplicate.
  - **Note:** 
    - However, the keys need to be hashable. Meaning we need our hash function to be deterministic.
      - To inforce this behaviour, we demand that the keys used in our hash-table are immutable data type.
    - Hash functions for files are more sophisticated than those  used for hash-tables.
    - For files we use ***Cryptographic hash functions*** also known as ***checksums***.
    - **Q:** How can we use this to our advantage to speedup object comparision?
      - *So, instead of directly comparing the objects a smarter approach is to first compare their hash values (if hash values already computed), and only when their hash values match we need to explicitly compare the objects.*
    - **Q:** What is the time complexity of hash function.
      - *The time complexity of a hash function depends on its implementation and the size of the input.*
      - *Generally, hash functions aim to be fast and efficient, typically operating in $O(1)$ **(constant time) for most cases**.*
    - **Q:** Consider the problem of trying to determine if two very large files have same content.
      - *if we precompute $H(file1)$ and $H(file2)$, first we should compare those hash values, since comparing hash values is $O(1)$*.
      - If possible we do not want to open either of the file directly.
      - Comparing their contents can be very slow, although we may have to if $H(file1)$ != $H(file2)$.
    - **Q:** How to maintain $O(1)$ insertion and lookup time complexity once my HashTable gets really full and I have long linked list chain?
      - Once HashTable contains lots of elements, we should create a new HashTable with a larger capacity and rehash all the items inside the old HashTable and disperse them thoughout the new HashTable at different locations.

  - **General Time complexity analysis:**

| Hash Function Type | Best Case | Average Case | Worst Case |
| ------------------ | --------- | ------------ | ---------- |
| Simple Hash (e.g., Modulo Hashing) | $O(1)$ | $O(1)$ | $O(1)$ |
| Cryptographic Hash (SHA-256, MD5, etc.) | $O(n)$ | $O(n)$ | $O(n)$ |
| Perfect Hashing | $O(1)$ | $O(1)$ | $O(1)$ |
| Universal Hashing | $O(1)$ | $O(1)$ | $O(n)$ (rare collision case)|

  - **Hash Function:**
    - A *hash function* $H(x)$ is a function that maps a key $x$ to a whole number in a fixed range.
    - **Properties of Hash function:**
      - If $H(x) = H(y)$ then objects $x$ and $y$ ***might be equal***, but if $H(x) != H(y)$ then $x$ and $y$ are ***certainly not equal***.
      - ***Deterministic:***
        - A Hash function $H(x)$ must be *deterministic*.
        - Meaning that if $H(x) = y$, then $H(x)$ must always produce $y$ and never different value.
      
      - ***Minimized Collisions***
        - We try very hard to make Uniform hash functions to minimize the number of hash collisions.
        - A collision occurs when two different inputs generate the same hash that is different inputs should produce different hashes as much as possible.
          - Cryptographic hash functions like SHA-256 aim to make collisions nearly impossible.

      - ***Fast Computation***
        - *The function should compute the hash value quickly, even for large inputs.*

      - ***Uniform Distribution***
        - The hash function should distribute values evenly to avoid clustering.
        - *Avalanche Effect:* 
          - A small change in input should result in a drastically different output.
        - **Example:**
          - *hash("Hello") → 5a8d3f*
          - *hash("hello") → f3e12b  (completely different)*
  
      - ***Irreversibility (One-way Function)***
        - Given a hash value, it should be computationally infeasible to determine the original input.
        - Important for password hashing and cryptography.
      
      - ***Fixed Output Size (Deterministic Size)***
        - No matter the input size, the hash output should always be of a fixed length.
          - **Example:**
            - MD5 → 128-bit output
            - SHA-256 → 256-bit output
      
      - ***Compression***
        - The hash function should reduce large input sizes into a shorter fixed-length output.
      
      - ***Pre-image Resistance***
        - Given a hash output $H$, it should be computationally hard to find the input $X$ such that $hash(X) = H$.
      
      - ***Second Pre-image Resistance***
        - Given an input $X1$, it should be hard to find another input $X2$ such that $hash(X1) = hash(X2)$.
      
      - ***Collision Resistance***
        - It should be very difficult to find two different inputs that result in the same hash value.
    
    - ***For Example:*** A function $H(x) = (x^2 - 6x + 9)$ *mod* $10$ maps all interger keys to the range $[0,9]$.
      - $H(4)$ = $(4^2 - 6*4 + 9)$ mod 10 **==>** $(16 - 24 + 9)$ mod 10 = $1$
      - $H(-7)$ = $(-7^2 - 6*-7 + 9)$ mod 10 **==>** $(49 - (-42) + 9)$ mod 10 = $0$
      - $H(0)$ = $(0^2 - 6*0 + 9)$ mod 10 **==>** $(0 - 0 + 9)$ mod 10 = $9$
      - $H(2)$ = $(2^2 - 6*2 + 9)$ mod 10 **==>** $(4 - 12 + 9)$ mod 10 = $1$
      - $H(8)$ = $(8^2 - 6*8 + 9)$ mod 10 **==>** $(64 - 48 + 9)$ mod 10 = $5$
    - A hash function can be defined for an arbitary objects such as *String, List, tuples, multi data objects etc.*
    - For a String *s* let $H(s)$ be a hash function defined below where ASCII(x) returns the ASCII value of the character *x*.
      - *ASCII('A') = 65*
      - *ASCII('B') = 65*
      - *ASCII('Z') = 90*
    - Below hash function take a String and returns numeric hash number in range of $[0,49]$.
    ```javascript
        // Hash function for String 
        function H(s):
          sum := 0
          for char in s:
            sum = sum + ASCII(char)
          return sum % 50
    ```
      - ***Example:***
        - $H("BB")$  **==>**  $(66 + 66)$ mod 50 = 32
        - $H("")$  **==>**  $(0)$ mod 50 = 0
        - $H("ABC")$  **==>**  $(65 + 66 + 67)$ mod 50 = 48
        - $H("Z")$  **==>**  $(90)$ mod 50 = 40

  - **How Hash-table works ?**
    - Ideally we would like to have a very fast insertion, lookup and removal time for the data we place within our hash table.
    - Remarkably we can achieve all this in $O(1)$ T.C. using a hash function as a way to index into a hash table.
    - The constant time behaviour attributed to hash tables is only true if we have a good ***uniform hash function***.

  - **Hash collision resolution:**
    - We can use one of the many hash collision resolution techniques to handle this.
    - The two most popular one's are ***seperate chaining*** & ***open addressing***.
    
    - ***Seperate chaining:***
      - Maintains a data structure (typically linkedlist, Balanced Tree) to hold all the different values which hashed to a particular value.
      - **Usages**
        - Used in *HashMap*, *Hashtable*, when mutiple keys collide they are stored in the same bucket as a list (or tree).
          - Each bucket stores a linked-list (java 7 and earlier) or a balanced binary tree (java 8+ when the list grows too large).
          - In java 8+, if the linked list grows beyond a *threshold (8 elements)*, it is converted into a balanced tree (Red-Black Tree) to improve lookup time from $O(n)$ → $O(log n)$.

    - ***Open Addressing:***
      - Deals with hash collision by finding another place within the hash table for the object to go by offsetting it from the position to which it hashed to.

    - ***Rehashing***
      - *Used in:* HashMap, Hashtable Resizing (when load factor exceeds threshold)
        - If the load factor (entries/capacity) exceeds 0.75, Java doubles the size of the array and rehashes all existing entries.
        - This reduces collisions but is an ***expensive operation***.
    - **Cuckoo Hashing (Less Common in Java):**
      - Uses two hash functions and stores each key in one of two possible locations.
      - If a collision occurs, the existing element is "kicked out" and reinserted using the other hash function.


- **Time complexity:**

| Operation | Average | Worst  |
| --------- | ------- | ------ |
| Insertion | $O(1)$  | $O(n)$ |
| Removal   | $O(1)$  | $O(n)$ |
| Search    | $O(1)$  | $O(n)$ |

- **Use cases:**
  - Track frequencies
    - We often use Hash Tables to track item frequencies. 
    - For instance, counting the number of times a word appears in a given text. We can use the word as key and a counter in value.
  - Caching
    - Used in web browsers, databases, and operating systems to store frequently accessed data.
    - Example: DNS caching, where domain names are mapped to IP addresses.
  - Database Indexing
    - Hash-based indexing improves query performance in databases.
    - Example: MySQL’s InnoDB engine uses hash indexes for certain workloads.
  - Symbol Tables in Compilers
    - Stores variable names, function names, and their associated values/types during compilation.
  - Fast Lookup in Key-Value Stores
    - Used in NoSQL databases (e.g., Redis, DynamoDB) to enable quick retrieval of values.
  - De-duplication (Removing Duplicates)
    - Used in applications like email spam filtering and duplicate detection in files.
  - Load Balancing
    - Hashing distributes requests among multiple servers in a consistent manner.
    - Example: Load balancers in distributed systems.
  - Cryptography (Hash Functions)
    - Used for password hashing, digital signatures, and checksums.
    - Example: Storing hashed passwords in authentication systems.
  - Implementing LRU (Least Recently Used) Cache
    - A combination of a hash table and a doubly linked list enables efficient eviction of least-used items.
  - Graph and Tree Algorithms
    - Hash tables are used for adjacency lists in graph representations.
    - Example: Checking if a node has been visited in graph traversal.

- **Implementation:**
  - **Hash-Table Seperate chaining:**
    - ***LinkedList based:*** [SeperateChainingHashTableImp.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/hashtable/SeperateChainingHashTableImp.java)

  - **Hash-Table Open Addressing:**
    - TODO - https://youtu.be/RBSGKlAvoiM?t=16545


- **<ins>References:</ins>**
  - [https://youtu.be/RBSGKlAvoiM?t=14365s](https://youtu.be/RBSGKlAvoiM?t=14365s)
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