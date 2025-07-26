# Stack DataStructure
## 1. Introduction

- **<ins>Data Structure</ins>**
  - A Stack is a one-ended linear data structure which models a real world stack by haing two primary operations, namely ***push*** and ***pop***.
    - ***push:***
      - Adds new element/data at *top* of the stack.
    - ***pop:***
      - Removes top element/data from the stack.
  - It can follow a particular order in which the operations are performed. 
    - ***LIFO(Last In First Out):***
      - LIFO implies that the element that is inserted last, comes out first.
      - **Java Stack *(java.util.Stack)* implementation** follows LIFO order.
    - ***FILO(First In Last Out):***
      - FILO implies that the element that is inserted first, comes out last.
  - **Terminology:**
    - *Top:* Points to the top element in the Stack.
- **Use case:**
  - Used by *undo* mechanishm in *Text Editors*.
  - Used by compiler syntax checking for matching brackets and braces.
  - Used behind the scense to support *recursion* y keeping track of previous function calls.
  - Can be used to do a *Depth First Search* on graphs.
  - Can be used to model a *Pile of Books or Plates* or even games like *Tower of Hanoi*.

- **Time Complexility**
 
| Operation  | T.C.  |
| ---------  | ----- |
| Push       | O(1)  |
| Pop        | O(1)  |
| Peek       | O(1)  |
| Size       | O(1)  |
| Search     | O(n)  |

- **Problem: Check if braces and brackets are properly closed in given String**
  - **Approach:**
    - *Step-1:* 
      - Loop through all the chars in string.
    - *Step-2:*
      - If the character is blank/whitespaces only, ignore
      - Read next character from String.
    - *Step-3:*
      - If the character is opening bracket add it in stack.
    - *Step-4:*
      - Get closing bracket for the given opening bracket.
    - *Step-5:*
      - If the stack is empty or the next element is not the matching opening bracket. 
      - return false, indicating *Invalid pairs*.
    - **Source code:** [FindMatchingBracketsInString.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/stack/problems/FindMatchingBracketsInString.java)
    ```java
        public static boolean hasMatchingBraces(String s) {
          Stack<Character> stack = new Stack<>();

          for (int i = 0; i < s.length(); i++) {
              char c = s.charAt(i);

              if (Character.toString(c).isBlank()) {
                  continue;
              }

              // is left/opening bracket
              if (isOpeningBracket(c)) {
                  stack.push(c);
                  continue;
              }

              char rev = getOpeningdBracket(c);
              if (stack.isEmpty() || stack.pop() != rev) {
                  System.out.println("Missing opening brackets for - " + rev);
                  return false;
              }
          }

          return true;
      }
    
    ```
- **Implementation:**
  - Stacks can often implemented using Arrays, Singly Linked List or Doubly Linked List.
  - **Arrays Implementation:**
    - ***Step-1:***
      - Initalize following 3 properties.
        - **data[]:** 
          - `private T[] data;`
            - *Hold data of defined type T.*
          - `private static int initialCapacity = 1 << 3;  // default capacity 2^3 = 8`
            - *Represents initial and current capacity of stack.*
          - `private int top = -1;`
            - *Hold the index of most recent object added in the stack.*
            - *`top` is sent to `-1`, When stack is empty.*
    - ***Step-2:***
        - Provide APIs for operations.
          - *push(T)*
            - Add data to stack.
            - Check if array is full double the array capacity.
            - `initialCapacity = initialCapacity << 1;`
            - `data = Arrays.copyOf(data, initialCapacity);`
          - *pop()*
            - Remove and return the top element from stack.
          - *peak()*
            - Return the top element from stack.
          - *size()*
          - *isEmpty()*
    
  - Check below link for Custom Implementation of Dynamic Array.
    - **Interface**: [Stack.java]  (https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/stack/Stack.java)
    ```java
          public interface Stack<T> {

              // Add element on top
              public void push(T elem);

              // Returns the last inserted element.
              public T pop();

              // Returns the last inserted element.
              public T peek();

              // Returns the no. of elements present in the stack.
              public int size();

              public boolean isEmpty();
          }    
    ```
    - **Implementation:** [ArrayStack.java](https://github.com/SRVivek1/grokking-coding-rounds/blob/main/a1-ds-algo-java/a1-ds-arrays/src/main/java/com/srvivek/dsalgo/stack/ArrayStack.java)
    ```java
        public class ArrayStack<T> implements Stack<T> {

          private T[] data;

          // Initial capacity 16
          private static int initialCapacity = 1 << 3;

          // Points to the most recent object pushed.
          private int top = -1;

          public ArrayStack() {
              this(initialCapacity);
          }

          @SuppressWarnings("unchecked")
          public ArrayStack(int capacity) {
              initialCapacity = capacity;
              data = (T[]) new Object[initialCapacity];
          }

          // Other API implementation
        }
    ```

- **<ins>References:</ins>**
  - [https://youtu.be/RBSGKlAvoiM?t=3570](https://youtu.be/RBSGKlAvoiM?t=3570)
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