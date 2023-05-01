import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    @Override
    public E getFirst() {
        Node<E> f = first;
        if(f==null){
            throw new NoSuchElementException();
        }
        return f.item;
    }

    @Override
    public E getLast() {
        Node<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        return l.item;
    }

    @Override
    public E removeFirst() {
        Node<E> f = first;
        if(f == null){
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        Node<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (MyLinkedList.Node<E> x = first; x != null; ) {
            MyLinkedList.Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;

    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        MyLinkedList.Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public int modCount = 0;
    public int size = 0;
    public Node<E> first;
    public Node<E> last;


    public MyLinkedList(){

    }


    // Link for first element
    private void linkFirst(E e) {
        final MyLinkedList.Node<E> f = first;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    // Link for last element
    void linkLast(E e) {
        final MyLinkedList.Node<E> l = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }


    private E unlinkFirst(MyLinkedList.Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final MyLinkedList.Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * Unlinks non-null last node l.
     */
    private E unlinkLast(MyLinkedList.Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final MyLinkedList.Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * Unlinks non-null node x.
     */
    E unlink(MyLinkedList.Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final MyLinkedList.Node<E> next = x.next;
        final MyLinkedList.Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    MyLinkedList.Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

}
