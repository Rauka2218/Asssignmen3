import java.util.*;
import jdk.internal.util.ArraysSupport;

public class MyArrayList<E> implements MyList<E> {

    private static final Object[] empty_array = {};

    private Object[] elements;
    private int size;
    private int modCount = 0;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E e) {
        modCount++;
        add(e, elements, size);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        final Object[] es = elements;
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    @Override
    public void clear() {
        modCount++;
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;

    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elements).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elements;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange(o,0,size);
    }

    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o,0,size);
    }

    E elementData(int index) {
        return (E) elements[index];
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elements;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    int lastIndexOfRange(Object o, int start, int end) {
        Object[] es = elements;
        if (o == null) {
            for (int i = end - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    void checkIndex(int index){
        if(index < 0 || index > size-1 ){
            throw new IndexOutOfBoundsException("");
        }

    }
    private Object[] grow(int minCapacity){
        int oldCapacity = elements.length;
        if(oldCapacity > 0 || elements != empty_array){
            int newCapacity = ArraysSupport.newLength(oldCapacity,minCapacity-oldCapacity, oldCapacity >> 1);
            return elements = Arrays.copyOf(elements,newCapacity);
        }
        else {
            return elements = new Object[Math.max(10,minCapacity)];
        }
    }
    private Object[] grow(){
        return grow(size+1);
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

}
