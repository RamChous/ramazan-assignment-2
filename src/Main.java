public class Main {
    public static void main(String[] args) {
        MyList<Integer> array = new MyLinkedList<>();
        array.add(23);
        array.add(14);
        array.addLast(100);
        array.addFirst(33);
        for (int i = 0; i < array.size(); i++)
            System.out.println(array.get(i));
        System.out.println("///////");
        array.add(2, 200);
        for (int i : array)
            System.out.println(i);
        System.out.println("//////");
        System.out.println(array.getFirst());
        System.out.println(array.getLast());
        System.out.println("//////");
        array.addFirst(1);
        array.addLast(9999);
        array.set(3, 2345);
        for (int i : array)
            System.out.println(i);
    }
}