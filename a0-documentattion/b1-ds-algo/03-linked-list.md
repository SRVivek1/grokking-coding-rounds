# Linked List DataStructure
## 1. Introduction

- **<ins>Data Structure</ins>**
  - A linked-list is a sequential list of nodes (linear data structure) that hold data and a poiner, which point to other nodes. It doesn't require *contiguos* memory allocation as array, instead each node will have a seperate memory allocaion and connected via pointer.
    - Last Node points to *null*.
  - It mainly allows efficient insertion and deletion operations compared to arrays. 
  - Like arrays, it is also used to implement other data structures like stack, queue and deque.
  - **Terminology:**
    - *Head:* The first node in the linked list.
    - *Tail:* The last node in the linked list.
    - *Pointer:* Reference to other node.
    - *Node:* An object containing data and pointer(s).
  - **Types:**
    - Singly Linked List (SLL)
      - Has 2 pointers *Head* & *Tail* for quick additions / removals.
      - Each node hold pointer only to it's next node.
      - **Pros:**
        - Simpler implementation
        - Uses less memory
      - **Cons:**
        - Can't access previous elements easily.
    - Double Linked List (DLL)
      - Has 2 pointers *Head* & *Tail* for quick additions / removals.
      - Each node holds pointer to previous as well as next nodes.
      - **Pros:**
        - Easy backward traversal.
      - **Cons:**
        - Requires 2x memory than Singly linked list.
    - Circular Linked List (CLL)
      - Singly Circular Linked List
      - Doubly Circular Linked List
  - **Use Cases:**
    - *Dynamic Data Structures:* 
      - Frequently changing size, e.g., list, stacks, queues.
      - Greate for creating *Circular Lists*.
        - These are used to model repeating event cycles such as RoundRobin ordering.
      - HashTable seperate chaining, to deal with hashing collision of keys.
    - *Efficient Insertions/Deletions:* 
      - For example, undo functionality in text editors.
      - Can easily model real wrorld objects such as Trains.
    - *Memory Allocation:* 
      - Used in operating systems for memory management.
  - **Advantages:**
    - *Dynamic Size:*
      - Unlike arrays, linked lists can grow or shrink dynamically without the need for resizing.
    - *Efficient Insertions/Deletions:*
      - Adding or removing elements (e.g., at the beginning, middle, or end) is more efficient compared to arrays, as no shifting of elements is required.
  - **Disadvantages:**
    - *Memory Overhead:*
      - Each node requires extra memory for the pointer(s).
    - *Sequential Access:*
      - Accessing an element requires traversal from the head (no direct indexing like arrays).
    - *Complexity:*
      - Compared to arrays, linked lists are more complex to implement and debug.


- **Time Complexility**
 
| Operation       | Singly LL | Doubly LL |
| ---------       | --------- | --------- |
| Search          | O(n)      | O(n)      |
| Insert (head)   | O(1)      | O(1)      |
| Insert (Tail)   | O(1)      | O(1)      |
| Remove (head)   | O(1)      | O(1)      |
| Remove (Tail)   | O(n)      | O(1)      |
| Remove (middle) | O(n)      | O(n)      |


- **Implementation: Doubly Linked List**
  - ***Step-1:***
    - Create a Node class to hold data and hold reference of previous and next nodes.
  - ***Step-2:***
    - Create DoublyLinkedList class.
      - Initialize 3 variable.
        ```java
            public class DoublyLinkedList<T> implements Iterable<T> {

                private int size = 0;
                private Node<T> head = null;
                private Node<T> tail = null;

                // Node class as inner class
                private static class Node<T> {
                    private T data;
                    private Node<T> prev, next;

                    public Node(T data, Node<T> prev, Node<T> next){
                        this.data = data;
                        this.prev = prev;
                        this.next = next;
                    }

                    @Override
                    public String toString() {
                        return data.toString();
                    }
                }

                // other API methods
            }
        ```
  - Check below link for Custom Implementation of Dynamic Array.
    - [DoublyLinkedList.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/linkedlist/DoublyLinkedList.java)

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