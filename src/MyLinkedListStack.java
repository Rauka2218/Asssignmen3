import java.util.EmptyStackException;

public class MyLinkedListStack<E> implements MyStack<E> {
    private MyLinkedList<E> myLinkedList;

    public MyLinkedListStack(){
        myLinkedList = new MyLinkedList<>();
    }

    @Override
    public void push(E element) {
        myLinkedList.addFirst(element);
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return  myLinkedList.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return  myLinkedList.getFirst();
    }

    @Override
    public int size() {
        return  myLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.getFirst() == null;
    }
}
