# Queue DataStructure
## 1. Introduction

- **<ins>Data Structure</ins>**
  - A queue is a Abstract Data type or linear data structure that follows the *First In, First Out (FIFO)* principle.
  - This means that the first element added to the queue is the first one to be removed, similar to a line of people waiting for their turn.
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
    - **Simple Queue:** 
      - A basic queue with FIFO behavior.
    - **Circular Queue:** 
      - The rear connects back to the front, making the queue circular. 
      - This avoids wasting space.
    - **Priority Queue:** 
      - Elements are dequeued based on their priority rather than their order in the queue.
    - **Double-Ended Queue (Deque):**
      - Elements can be enqueue / added and dequeue / removed from both ends of the queue.
  - **Terminology:**
    - *front:*
      - A pointer/reference pointing to the first element of the Queue.
    - *rear:* 
      - A pointer/reference pointing to the last element of the Queue.
  - **Use case:**
    - *Task Scheduling:* 
      - Used in CPU scheduling and disk scheduling.
    - *Data Transfer:* 
      - Buffers in data communication, like printers or keyboards.
    - *Breadth-First Search (BFS):* 
      - Used in graph traversal algorithms.
    - *Waiting Lines:*
      - Simulation of real-world queues, like customer service systems.
    - *LRU Cache Implementation:*
      - Finds and removes Least Recently Used (LRU) cached data.
- **Time Complexility**
 
| Operation  | T.C.  | Operation  | T.C.  |
| ---------  | ----- | ---------  | ----- |
| Enqueue    | O(1)  | Contains   | O(n)  |
| Dequeue    | O(1)  | Removal    | O(n)  |
| Peeking    | O(1)  | IsEmpty    | O(1)  |

- **Queue DS Implementation:**
  - We can implement Queue using different data structures *Array, SinglyLinkedList* or *DoublyLinkedList*
  - **LinekdList Implementation**
    - Using `java.util.LinkedList` to implement queue.
    - Note: In Java colletions **LinkedList** is a **Queue** as it implements `Queue interface`.
    - ***Step-1:***
      - Create a Queue interface and define the API methods.
      - Create LinkedListQueue class and declare following properties.
        - *java.util.LinkedList* object to hold the data.
        - Initialize *size* property of `Integer` with *0*. 
    - ***Step-2:***
      - Use java LinkedList provided APIs to provide implementation to the Queue Interface APIs.
      - Note:
        - Always add new objects in the beginning.
        - Always read or remove objects from last/end.
    - **Github link:** [Queue.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/Queue.java)
    ```java
        public interface Queue<T> {

            public void offer(T elem);

            public T poll();

            public T peak();

            public int size();

            public  boolean isEmpty();
        }
    ```
    - **Github link:** [LinkedListQueue.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/LinkedListQueue.java)
    ```java
        public class LinkedListQueue<T> implements Queue<T> {

          private final LinkedList<T> data;
          private int size;

          public LinkedListQueue() {
              data = new LinkedList<>();
              size = 0;
          }

          public LinkedListQueue(T elem) {
              data = new LinkedList<>();
              offer(elem);
          }


          @Override
          public void offer(T elem) {
              data.addFirst(elem);
              size++;
          }

          @Override
          public T poll() {
              T elem = data.getLast();
              data.removeLast();
              size--;
              return elem;
          }

          @Override
          public T peak() {
              return data.getLast();
          }

          @Override
          public int size() {
              return size;
          }

          @Override
          public boolean isEmpty() {
              return size == 0;
          }

          @Override
          public String toString() {
              return data.toString();
          }
      }
    ```
  - **Array Implementation**
    - Using array to implement queue.
    - ***Step-1:***
      - Create ArrayQueue class and declare following properties.
        - *T[]* object to hold the data.
        - Initialize *rear and front* properties of `Integer` with *0*. 
    - ***Step-2:***
      - Update rear and front pointers when an object is added or removed.
      - Note:
        - Always add new objects in the end.
        - Always read or remove objects from beginning.
    -  **Github link:** [ArrayQueue.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/ArrayQueue.java)
    ```java
        public class ArrayQueue<T> implements Queue<T> {

          private final T[] arr;
          private int front;
          private int rear;

          // Initial capacity is 8
          private static int initialCapacity = 1 << 3;

          public ArrayQueue() {
              this(initialCapacity);
          }

          @SuppressWarnings("unchecked")
          public ArrayQueue(int capacity) {
              initialCapacity = capacity;
              arr = (T[]) new Object[initialCapacity];
              front = rear = 0;
          }

          @Override
          public void offer(T elem) {
              if (isFull()) {
                  throw new RuntimeException("Queue is full.");
              }
              arr[rear++] = elem;
              rear = adjustIndex(rear, arr.length);
          }

          @Override
          public T poll() {
              if (isEmpty()) {
                throw new RuntimeException("Queue is empty.");
              }
              front = adjustIndex(front, arr.length);
              return arr[front++];
          }

          @Override
          public T peak() {
              if (isEmpty()) {
                throw new RuntimeException("Queue is empty.");
              }
              front = adjustIndex(front, arr.length);
              return arr[front];
          }

          @Override
          public int size() {
              return adjustIndex(rear + arr.length - front, arr.length);
          }

          @Override
          public boolean isEmpty() {
              return front == rear;
          }

          /**
           * Return current index if it's less than array length, else return (index - length).
          *
          * @param index index
          * @param length array length
          * @return effective Index
          */
          private int adjustIndex(int index, int length) {
              return index >= length ? index - length : index;
          }

          /**
           * Checks if Queue is full.
          */
          private boolean isFull() {
              return (front + arr.length - rear) % arr.length == 1;
          }

          @Override
          public String toString() {
              return ... ;
          }
      }
    ```
- **Problem: BFS (Breadth-First search) for a graph**
  - Traverses a graph by visiting every *vertex* once and only once.
  - To Begin the traversal we must provide/choose the starting *vertex*.
  - **Graph Terms:**
    - *Vertices:*
      - Represents the number of nodes in the graph.
    - *Edges:*
      - Represent the number of paths(Lines) connecting all the nodes.
    - **Note:**
      - Two nodes are used to represent the vertex which connects them. Eg. [Node1, Node3]
      - In an undirected graph the order of nodes doen't matter.
  - **Approach/Sudo-code:**
      ```java
          //Let Q be a Queue
          Q.enqueue(starting_node)
          starting_node.visited = true

          while Q is not empty Do
            node = Q.dequeue()
            // do business with node data

            for neighbour in  neighbours(node):
              if neighour is not visited:
                neighbour.visited = true
                Q.enqueue(neighbour)
      ``` 
    - **Source code:** **Github link:** [BreadthFirstSearch.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/queue/problems/BreadthFirstSearchApp.java)
    ```java
            /**
            * Traverse all the connected nodes starting from given node in the graph.
            *
            * @param adjacecyList
            * @param sourceNode
            */
            private static void breadFirstSearch(List<List<Integer>> adjacecyList, int sourceNode) {

                final boolean[] visitTracker = new boolean[adjacecyList.size()];
                final Queue<Integer> queue = new LinkedList<>();

                // mark source as visited
                visitTracker[sourceNode] = true;

                // add current node in queue
                queue.add(sourceNode);

                while (!queue.isEmpty()) {
                    // get the Node (int) from the queue
                    Integer t = queue.poll();
                    System.out.println("Node : " + t);

                    for (int node : adjacecyList.get(t)) {
                        if(!visitTracker[node]) {
                            System.out.println("  Processing node : " + node);
                            visitTracker[node] = true;
                            System.out.println("  Visited: " + node);
                            queue.add(node);
                        } else {
                            System.out.println("  Skipping visited node : " + node);
                        }
                    }
                    System.out.println("Queue : " + queue.toString());
                }
            }

            /**
            * Add the edge link in the list.
            *
            * @param adjacecyList
            * @param u
            * @param v
            */
            private static void addEdge(List<List<Integer>> adjacecyList, int u, int v) {
                adjacecyList.get(u).add(v);

                // Undirected graph
                adjacecyList.get(v).add(u);
            }
    ```
- **<ins>References:</ins>**
  - [https://youtu.be/RBSGKlAvoiM?t=3570](https://youtu.be/RBSGKlAvoiM?t=3570)
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