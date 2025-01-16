<center>
<h1> Design Patterns </h1>
</center>

### **<ins>About / Introduction</ins>**
  - Design patterns are typical solutions to common problems in software design.
  - Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.
  - **Benefits of patterns:**
    - Patterns are a toolkit of solutions to common problems in software design.
    - They define a common language that helps your team communicate more efficiently. 
  - **Classification:**
    - Design patterns differ by their complexity, level of detail and scale of applicability. In addition, they can be categorized by their intent and divided into three groups.
    - The most basic and low-level patterns are often called idioms. They usually apply only to a single programming language.
    - The most universal and high-level patterns are architectural patterns. Developers can implement these patterns in virtually any language. Unlike other patterns, they can be used to design the architecture of an entire application.
    - All patterns can be categorized by their intent, or purpose. Here we'll discuss the three main groups of patterns:
      - **1. Creational:** 
        - The design patterns that deal with the creation of an object.
      - **2. Structural:** 
        - These design patterns deals with the class structure such as Inheritance and Composition.
      - **3. Behavioral:**
        - These design patterns provide solution for the better interaction between objects. 
        - How to provide lose coupling, and flexibility to extend easily in future.

### **<ins>Design Patters</ins>**

| Category | Design Pattern | Info | Example |
| -------- | -------------- | ---- | ------- |
| **Creational D.P.** |     | There are **5** design patterns in this category. |  |
|          | *Singleton* | Restricts the initialization of a class to only one instance of the class per JVM. |  |
|    | *Factory* | Takes out the responsibility of instantiating a object from the class to a Factory class. |  |
|    | *Absstract Factory* | Allows us to create a Factory for factory classes. |  |
|    | *Builder* | Creating an object step by step and a method to finally get the object instance. |  |
|    | *Prototype* | Creating a new object instance from another similar instance and then modify according to our requirements. |  |
| **Structural D.P.** |     |  There are **7** design patterns defined in this category. |  |
|    | *Adapter* | Provides an interface between two unrelated entities so that they can work together. |  |
|    | *Composite* | Used when we have to implement a part-whole hierarchy. For example, a diagram made of other pieces such as circle, square, triangle, etc. |  |
|    | *Proxy* | Provide a surrogate or placeholder for another object to control access to it. |  |
|    | *Flyweight* | Caching and reusing object instances, used with immutable objects. | Java String pool |
|    | *Faced* | Creating a wrapper interfaces on top of existing interfaces to help client applications. |  |
|    | *Bridge* | The bridge design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client program. |  |
|    | *Decorator* | The decorator design pattern is used to modify the functionality of an object at runtime. |  |
|  **Behavioral D.P.**  |  | There are **11** design patterns defined in this category. |  |
|    | *Template Method* | Used to create a template method stub and defer some of the steps of implementation to the subclasses. |  |
|    | *Mediator* | Used to provide a centralized communication medium between different objects in a system. |  |
|    | *Chain of Responsibility* | Used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. |  |
|    | *Observer* | Get notified whenever there is any change in the state of an object. |  |
|    | *Strategy* | Used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime. |  |
|    | *Command* | Command Pattern is used to implement lose coupling in a request-response model. |  |
|    | *State* | State design pattern is used when an Object change it’s behavior based on it’s internal state. |  |
|    | *Visitor* | Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. |  |
|    | *Interpretor* | Defines a grammatical representation for a language and provides an interpreter to deal with this grammar. |  |
|    | *Iterator* | Used to provide a standard way to traverse through a group of Objects. |  |
|    | *Memento* | Used when we want to save the state of an object so that we can restore later on. |  |
| | | |  |

- **<ins>References:</ins>**
  - [https://www.digitalocean.com/community/tutorials/gangs-of-four-gof-design-patterns](https://www.digitalocean.com/community/tutorials/gangs-of-four-gof-design-patterns)
  - [https://refactoring.guru/design-patterns](https://refactoring.guru/design-patterns)
  - [https://www.geeksforgeeks.org/software-design-patterns/] (https://www.geeksforgeeks.org/software-design-patterns/)
---

<center>
<h1> ------ End ------ </h1>
</center>
