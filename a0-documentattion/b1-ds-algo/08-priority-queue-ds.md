# Priority Queue (PQ) Data Structure and Heap
## 1. Introduction

- **<ins>PQ Data Structure</ins>**
  - A ***Priority Queue*** is an *Abastract Data Type (ADT)* that operates similar to a normal queue except that in priority queue *each element has a certain priority*.
  - The *priority* of the elements in the priority queue determines the order in which the elements are removed from the queue.
  - **Note:**
    - Priority Queue only supports *comparable data*, meaning that the data inserted into the priority queue must be able to be ordered in someway - either from least to greatest or from greatest to least.
  - There are several ways to implement a priority queue, including using an array, linked list, heap, or binary search tree, binary heap being the most common method to implement. 
    - The reason for using Binary Heap is, in binary heaps, we have easy access to the min (in min heap) or max (in max heap) and binary heap being a complete binary tree are easily implemented using arrays. 
    - Since we use arrays, we have cache friendliness advantage also.
  - It provides two primary operations *enqueue* and *dequeue*.
    - ***enqueue:***
      - Adding an element/data at *end* of the queue.
      - Also called as offering / adding / pushing.
    - ***dequeue:***
      - Removing an element/data from the front of the queue.
      - Also called as polling / removing / popping.
    - ***peeking:***
      - Get the element from front of the queue without removing it.
  - **Types of Queues:**
    - *Min-Priority Queue:*
      - The element with the lowest priority (smallest value) is dequeued first.
        - **Example:** A queue to determine the shortest path in Dijkstra’s algorithm.
    - *Max-Priority Queue:*
      - The element with the highest priority (largest value) is dequeued first.
        - **Example:** A task scheduler where higher priority tasks are executed first.
  - **Terminology:**
    - *front:*
      - A pointer/reference pointing to the first element of the Queue.
    - *rear:* 
      - A pointer/reference pointing to the last element of the Queue.

- **Applications of PQs:**
  - Used in certain implementations of *Dijkstra's Shortest path algorithm*.
  - Anytime when we need to dynamically fetch *next best* or *next worst* element.
  - *Loseless data compression:* Used in *Huffman coding*, which is often used for loseless data compression.
  - Best First Search (BFS) algorithms: Such as A* uses PQs continuously grap the next most promising node.
  - Used by Minimun Spanning Tree (MST) algorithms.

- **Time Complexility**
  - ***PQ with Binary Heap:***

|     Operation      |    T.C.   |
| ------------------ | --------- |
| polling            | O(log N)  |
| peeking            | O(1)      |
| Adding             | O(log N)  |
| Naive Removing     | O(n)      |
| Advanced Removing with <br/> help from a Hash-table.  | O(log(n))      |
| Naive Contains          | O(n)      |
| Contains check with <br/> help of Hash-table.   | O(1)  |


- **Priority Queue (PQ) DS Implementation:**
  - PQs are usually implemented with ***heap data structure*** since they give us the best possible time complexity.
  - Alternatively there are many other type of Heap DS we can use to implement *Priority Queue*, e.g. - Binary Heap, Fibonacci Heap, Binomial Heap, Pairing Heap.
  - **Note:**
    - A PQ is not a Heap but it's ADT to defines the behaviour a PQ should have.
    - Since PQ are the Abstract Data types (ADT), hence *Heaps* are not the only way to implement PQs.
    - As an example, we could use an *unsorted list* but this would not give us the best possible time complexity.
- **Java PriorityQueue demo:**
  - [JavaPriorityQueueTestApp.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/JavaPriorityQueueTestApp.java)

- **Problem: Change MinPQ into MaxPQ**
  - Often the standard library of most programming languages only provide a Min-PQ which sorts the smallest elements first but sometimes we need a Max-PQ.
  - **Hint:**
    - Since the elements in the priority queue are comparable, they implement some sort of *Comparable Inerface* which we can simply negate to achieve a Max PQ (Max Heap).
  
  - **Approach 1: Using custom Comparable**
    - In MinPQ when data is inserted a comparision is done to decide the lowest between two to keep it on top which we can use a custom comparable to return the highest number in the comparision which will be kept on top.

    - **Source code:** **Github link:** [MinPQToMaxPQUsingComparable.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/problems/MinPQToMaxPQUsingComparable.java)
    ```java
        /**
          * Create Max priority queue using provided data.
          *
          * @param data
          * @return
          */
          private static Queue<Integer> constructMaxPQueue(int[] data) {
              /*
              * Comparator returns a negative integer, zero, or a positive integer as the first argument
              * is less than, equal to, or greater than the second.
              */
              final Queue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {

                  /**
                   * {@inheritDoc}
                  *
                  * Reverse the return value to get Max Priority Queue.
                  *
                  * arg1 < arg2 ----> 1 [Default / MinPQ will return 1]
                  * arg1 < arg2 ----> 0 [Default / MinPQ will return 0]
                  * arg1 < arg2 ----> -1 [Default / MinPQ will return -1]
                  *
                  * @param arg1 the first object to be compared.
                  * @param arg2 the second object to be compared.
                  * @return
                  */
                  @Override
                  public int compare(Integer arg1, Integer arg2) {
                      if (arg1 > arg2) {
                          return -1;
                      } else if (arg1.equals(arg2)) {
                          return 0;
                      } else {
                          return 1;
                      }
                  }
              });

              StringBuilder sb = new StringBuilder("Input array: [");
              for (int t : data) {
                  maxPQ.offer(t);
                  sb.append(t).append(", ");
              }
              sb.append("]");
              System.out.println(sb);
              return maxPQ;
          }
    ```

  -  **Approach 2: Negate the numbers**
     -  Another way could be we can negate the numbers before adding them in the PQ and as well know $-1 > -2$. 
     -  Hence every time we'll poll() the queue we'll get the highest negative number which can be change back to original value by negative again..
       
    - **Source code:** **Github link:** [MinPQToMaxPQByNegatingValues.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/problems/MinPQToMaxPQByNegatingValues.java)
    ```java
        /**
          * Create Max priority queue using provided data.
          *
          * @param data
          * @return
          */
          private static Queue<Integer> constructMaxPQueue(int[] data) {

              final Queue<Integer> maxPQ = new PriorityQueue<>();

              StringBuilder sb = new StringBuilder("Input array: [");
              for (int t : data) {
                  /*
                  * Negate the value while adding to the queue.
                  * While polling back, negate them back before processing
                  */
                  maxPQ.offer(t * -1);
                  sb.append(t).append(", ");
              }
              sb.append("]");
              System.out.println(sb);
              return maxPQ;
          }

        /**
          * Print Queue data using `poll()` API.
          *
          * @param queue
          */
          private static void print(Queue<Integer> queue) {

              queue = new PriorityQueue<>(queue);
              StringBuilder sb = new StringBuilder("MaxPQ : ").append(" {");

              while (!queue.isEmpty()) {
                  /*
                  * Negating the value to transform it to the actual value.
                  */
                  sb.append(queue.poll() * -1).append(", ");
              }
              sb.append("}");
              System.out.println(sb.toString());
          }
    ```

- **<ins>References:</ins>**
  - [https://youtu.be/RBSGKlAvoiM?t=5493](https://youtu.be/RBSGKlAvoiM?t=5493)
  - [BFS Queue / Graph Explanation] (https://www.youtube.com/watch?v=OsNklbh9gYI)
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