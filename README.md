﻿	Java Data Structures
Java Data Structures is a project that provides various implementations of data structures in Java. The project includes classes that implement lists, stacks, and queues, among other data structures. These classes can be used in Java projects to create and manipulate data structures.

	MyArrayList
The MyArrayList class implements an array-based list. It provides methods for adding, removing, and accessing elements in the list. If the size of the array is not large enough to accommodate a new element, the implementation creates a new array with double the size of the original array.

	MyArrayListStack
The MyArrayListStack class is an implementation of a stack using MyArrayList. It provides standard stack operations, including push, pop, peek, isEmpty, and size.

	MyArrayListQueue
The MyArrayListQueue class is an implementation of a queue using MyArrayList. It provides standard queue operations, including enqueue, dequeue, peek, isEmpty, and size.

	Getting Started
Prerequisites
To use these data structures, you need to have Java 8 or later installed on your system.

	Installation
Download the source code for the desired data structure implementation.
Compile the code using a Java compiler.
Use the compiled classes in your own Java projects.
	
	Usage
To use any of the data structures, simply create an instance of the appropriate class and call its methods to add, remove, or access elements. Here's an example usage of MyArrayList:
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
public static void main(String[] args) {
MyArrayListStack<Integer> array = new MyArrayListStack<>();
array.push(1);
array.push(2);
array.push(3);
array.push(4);
array.push(5);
array.push(7);
System.out.println(array.size());
System.out.println(array.isEmpty());
MyArrayListQueue<Integer> arrayListQueue = new MyArrayListQueue<>();
arrayListQueue.enqueue(1);
arrayListQueue.enqueue(2);
arrayListQueue.enqueue(3);

        MyLinkedListQueue<Integer> myLinkedListQueue = new MyLinkedListQueue<>();
        myLinkedListQueue.enqueue(2);
        myLinkedListQueue.enqueue(3);
        myLinkedListQueue.enqueue(5);
        myLinkedListQueue.enqueue(6);
        myLinkedListQueue.enqueue(7);
    }
}
