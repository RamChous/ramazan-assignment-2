public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(23);
        heap.insert(14);
        heap.insert(33);
        heap.insert(1);
        heap.insert(2);
        System.out.println(heap.getMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.getMin());
        System.out.println(heap.size());
    }
}