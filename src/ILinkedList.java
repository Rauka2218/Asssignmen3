public interface ILinkedList<E> {
    E getFirst();
    E getLast();

    E removeFirst();
    E removeLast();
    void addFirst(E e);

    void addLast(E e);
    int size();
    boolean contains(Object o);
    boolean add(E e);
    boolean remove(Object o);

    void clear();

    E get(int index);
    E set(int index, E element);
    void add(int index,E element);
    E remove(int index);
}
