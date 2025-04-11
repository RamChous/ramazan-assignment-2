import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private T[] array;
    private int size;
    private int capacity = 5;

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

    }

    @Override
    public void addLast(T Item) {

    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
