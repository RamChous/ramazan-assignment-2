public class Main {
    public static void main(String[] args) {
        MyList<Integer> array = new MyArrayList<>();
        array.add(33);
        array.add(16);
        array.add(23);
        array.add(7);
        array.add(23);
        array.add(99);
        for (int i = 0; i < array.size(); i++)
            System.out.println(array.get(i));
        System.out.println("///////////////////////");
        System.out.println(array.getFirst());
        System.out.println(array.getLast());
        array.addFirst(1);
        array.addLast(1000);
        for (int i = 0; i < array.size(); i++)
            System.out.println(array.get(i));
    }
}