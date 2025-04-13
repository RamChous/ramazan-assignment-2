public class MyStack<T> {
    private final MyList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item){
        list.addFirst(item);
    }

    public T pop(){
        T pop = list.getFirst();
        list.removeFirst();
        return pop;
    }

    public T peek(){
        return list.getFirst();
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }
}
