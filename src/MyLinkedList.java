import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){}

    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> prev;
        MyNode(E data, MyNode<E> prev, MyNode<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<T> node(int index){
        MyNode<T> current;
        if (index < size / 2){
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    private void unlink(MyNode<T> newNode){
        T element = newNode.data;
        MyNode<T> prev = newNode.prev;
        MyNode<T> next = newNode.next;
        if (prev == null)
            head = next;
        else {
            prev.next = next;
            newNode.prev = null;
        }
        if (next == null)
            tail = prev;
        else{
            next.prev = prev;
            newNode.next = null;
        }
        newNode.data = null;
        size--;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> newNode = node(index);
        newNode.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> next = node(index);
            MyNode<T> prev = next.prev;
            MyNode<T> newNode = new MyNode<>(item, prev, next);
            newNode.next = next;
            newNode.prev = prev;
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> h = head;
        MyNode<T> newNode = new MyNode<>(item, null, h);
        head = newNode;
        if (h == null)
            tail = newNode;
        else h.prev = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> t = tail;
        MyNode<T> newNode = new MyNode<>(item, t, null);
        tail = newNode;
        if (t == null)
            head = newNode;
        else t.next = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        return node(index).data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        unlink(node(index));
    }

    @Override
    public void removeFirst() {
        unlink(head);
    }

    @Override
    public void removeLast() {
        unlink(tail);
    }

    @Override
    public void sort(Comparator<T> cmp) {
        for (int i = 0; i < size - 1; i++){
            MyNode<T> current = head;
            for (int j = 0; j < size - 1 - i; j++){
                if (cmp.compare(current.data, current.next.data) > 0){
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        if (object == null){
            for (MyNode<T> current = head; current != null; current = current.next){
                if (current.data == null)
                    return index;
                index++;
            }
        } else {
            for (MyNode<T> current = head; current != null; current = current.next){
                if (object.equals(current.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size;
        if (object == null){
            for (MyNode<T> current = tail; current != null; current = current.prev){
                index--;
                if (current.data == null)
                    return index;
            }
        } else {
            for (MyNode<T> current = tail; current != null; current = current.prev){
                index--;
                if (object.equals(current.data))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for(MyNode<T> current = head; current != null; current = current.next)
            result[i++] = current.data;
        return result;
    }

    @Override
    public void clear() {
        MyNode<T> current = head;
        while (current != null){
            MyNode<T> next = current.next;
            current.data = null;
            current.prev = null;
            current.next = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        MyNode<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T nextItem = cursor.data;
            cursor = cursor.next;
            return nextItem;
        }
    }
}
