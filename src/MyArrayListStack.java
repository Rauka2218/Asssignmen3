import java.util.EmptyStackException;

public class MyArrayListStack<E> implements MyStack<E> {

    private MyArrayList<E> myArrayList;


    public MyArrayListStack(){
        myArrayList = new MyArrayList<>();
    }
    @Override
    public void push(E element) {
        myArrayList.add(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return myArrayList.remove(myArrayList.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return myArrayList.get(myArrayList.size() - 1);
    }

    @Override
    public int size() {
        return myArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return myArrayList.isEmpty();
    }
}
