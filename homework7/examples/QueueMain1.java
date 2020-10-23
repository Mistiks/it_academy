package homeworks.homework7.examples;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(10);
        queue.offer(100);
        System.out.println("Созданная очередь: " + queue);
        System.out.println("Голова очереди (метод element): " + queue.element());
        System.out.println("Голова очереди (метод peek): " + queue.peek());

        queue.remove();
        System.out.println("Очередь после метода remove: " + queue);
        queue.poll();
        System.out.println("Очередь после метода poll: " + queue);
    }
}
