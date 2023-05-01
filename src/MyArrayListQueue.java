import java.util.NoSuchElementException;

public class MyArrayListQueue<E> implements MyQueue<E> {
    private MyArrayList<E> myArrayList;

    public MyArrayListQueue(){
        myArrayList = new MyArrayList<>();
    }
    @Override
    public void enqueue(E element) {
        myArrayList.add(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return myArrayList.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return myArrayList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return myArrayList.isEmpty();
    }

    @Override
    public int size() {
        return myArrayList.size();
    }
}
