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