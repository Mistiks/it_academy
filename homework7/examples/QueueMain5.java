package homeworks.homework7.examples;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(null);
        System.out.println("Созданная очередь: " + queue);
        System.out.println("Голова очереди (метод element): " + queue.element());
    }
}
