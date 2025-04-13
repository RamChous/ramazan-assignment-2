import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println(stack.empty());

        stack.push(23);
        stack.push(14);
        stack.push(99);
        stack.push(1);

        System.out.println(stack.empty());

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.size());
    }
}