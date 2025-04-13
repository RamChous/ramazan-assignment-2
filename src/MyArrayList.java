import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private T[] array;
    private int size;  // how many element it actually has
    private int capacity = 5;  // how many elements it can store

    public MyArrayList(){
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (size == capacity){
            capacity = 2 * capacity;
            Object[] array2 = new Object[capacity];
            for (int i = 0; i < size; i++)
                array2[i] = array[i];
            array = (T[]) array2;
        }
        array[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size == capacity){
            capacity = 2 * capacity;
            Object[] array2 = new Object[capacity];
            for (int i = 0; i < size; i++)
                array2[i] = array[i];
            array = (T[]) array2;
        }
        for (int i = size - 1; i >= index; i--)
            array[i + 1] = array[i];
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T getFirst() {
        return array[0];
    }

    @Override
    public T getLast() {
        return array[size - 1];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        array[size - 1] = null;
        size--;
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
    }

    @Override
    public void removeLast() {
        for (int i = 0; i < size - 1; i++)
            array[i] = array[i];
        size--;
    }

    @Override
    public void sort(Comparator<T> cmp) {  // bubble sort with comparator to compare objects
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                T current = array[j];
                T next = array[j + 1];
                if (cmp.compare(current, next) > 0){
                    array[j] = next;
                    array[j + 1] = current;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {  // finds the index of first occurrence of an object
        if (object == null){
            for (int i = 0; i < size; i++)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {  // finds the index of last occurrence of an object
        if (object == null){
            for (int i = size; i >= 0; i--)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = size; i >= 0; i--)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array2 = new Object[size];
        for (int i = 0; i < size; i++)
            array2[i] = array[i];
        return array2;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {  // needed to iterate through the collection
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}
