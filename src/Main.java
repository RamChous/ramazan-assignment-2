import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println(queue.empty());

        queue.enqueue(23);
        queue.enqueue(14);
        queue.enqueue(99);
        queue.enqueue(1);

        System.out.println(queue.empty());

        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.peek());
    }
}