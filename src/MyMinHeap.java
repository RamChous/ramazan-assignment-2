public class MyMinHeap<T extends Comparable<T>>{
    private MyList<T> heap;

    public MyMinHeap(){
        heap = new MyArrayList<>();
        heap.add(null);  // first element (index=0) must be null
    }

    //     PUBLIC METHODS
    public boolean empty(){
        return heap.size() == 1;
    }

    public int size(){
        return heap.size() - 1;
    }

    public T getMin(){
        return heap.get(1);
    }

    public T extractMin(){
        T min = heap.get(1);
        T last = heap.getLast();
        heap.removeLast();
        if (!empty()){
            heap.set(1, last);
            heapify(1);
        }
        return min;
    }

    public void insert(T item){
        heap.add(item);
        traverseUp(size());
    }

    //     PRIVATE METHODS
    private void heapify(int index){
        int min = index;
        int left = leftChildOf(index);
        int right = rightChileOf(index);
        if (left <= size() && heap.get(left).compareTo(heap.get(min)) < 0)
            min = left;
        if (right <= size() && heap.get(right).compareTo(heap.get(min)) < 0)
            min = right;
        if (min != index){
            swap(index, min);
            heapify(min);
        }
    }

    private void traverseUp(int index){
        while (index > 1 && heap.get(index).compareTo(heap.get(parentOf(index))) < 0){
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    private int leftChildOf(int index){
        return 2 * index;
    }

    private int rightChileOf(int index){
        return 2 * index + 1;
    }

    private int parentOf(int index){
        return index / 2;
    }

    private void swap(int i, int j){
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
