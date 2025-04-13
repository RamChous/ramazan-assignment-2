import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> array = new MyLinkedList<>();
        array.add(23);
        array.add(14);
        array.add(34);
        array.add(14);
        array.add(99);
        array.add(1);
        for (int i : array)
            System.out.println(i);
        System.out.println("//////////");
        array.sort(Comparator.naturalOrder());
        for (int i : array)
            System.out.println(i);
    }
}