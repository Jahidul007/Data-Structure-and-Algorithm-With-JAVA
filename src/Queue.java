import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");

        System.out.printf("%s ", queue);
        System.out.println();

        System.out.printf("%s ",queue.peek());
        System.out.println();

        queue.poll();
        System.out.printf("%s ",queue);
    }
}
