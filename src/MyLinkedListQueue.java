import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> implements MyQueue<E> {
    MyLinkedList<E> myLinkedList;

    public MyLinkedListQueue(){
        myLinkedList = new MyLinkedList<>();
    }
    @Override
    public void enqueue(E element) {
        myLinkedList.addLast(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return myLinkedList.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return myLinkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.getFirst() == null;
    }

    @Override
    public int size() {
        return myLinkedList.size();
    }
}
