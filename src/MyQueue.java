public class MyQueue<T> {
    private final MyList<T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public T peek(){
        return list.getFirst();
    }

    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    public int size(){
        return list.size();
    }

    public boolean empty(){
        return list.size() == 0;
    }
}
