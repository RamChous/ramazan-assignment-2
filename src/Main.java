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
        System.out.println(array.indexOf(14));
        System.out.println(array.lastIndexOf(14));
        System.out.println("//////////");
        array.remove(2);
        array.removeFirst();
        array.removeLast();
        for (int i : array)
            System.out.println(i);
        System.out.println("//////////");
        array.toArray();
        for (int i : array)
            System.out.println(i);
        System.out.println("//////////");
        System.out.println(array.exists(14));
        System.out.println(array.exists(11));
        System.out.println("//////////");
        array.clear();
        for (int i : array)
            System.out.println(i);
        System.out.println(array.size());
    }
}