# Assignment 2 - Java Data Structures
___
This project is an implementation of various data structures in Java, including:
- **ArrayList**: Implementation of array list with basic methods such as adding, removing and sorting.
- **LinkedList**: Implementation of a linked list with basic methods like for adding, removing and sorting.
- **Stack**: stack implemented based on linked list.
- **Queue**: queue implemented based linked list.
- **MinHeap**: min-heap with insertion, min-extraction, and heap property recovery operations.
## Explanation
___
**Stack** and **Queue** are based on linked list because of its inserting and deleting efficiency (O(1)) even if it takes up more memory compared to array list.
<br><br>
In other hand **MinHeap** based on array list due to access of elements by indexes that takes O(log n) operations instead of O(n) in linked list.
## How to run
___
1. **Clone this repository:**
   ```bash
   git clone https://github.com/RamChous/ramazan-assignment-2.git
2. **Open project in your IDE**
3. **Compile and run the Main.java file**
## Example
___
You can see example of usage in Main.java file:
```java
public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(23);
        heap.insert(14);
        heap.insert(33);
        heap.insert(1);
        heap.insert(2);
        System.out.println(heap.getMin()); // 1
        System.out.println(heap.extractMin()); // 1
        System.out.println(heap.getMin()); // 2
        System.out.println(heap.size()); // 4
    }
}
```
**Note**: In order to sort array list or linked list you have to import java.util.Comparator in Main.java.
## Technologies
___
- Java 17
- Standard Java library