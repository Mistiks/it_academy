package homeworks.homework7.examples;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain4 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println("Созданная очередь: " + queue);
        System.out.println("Голова очереди (метод element): " + queue.element());
    }
}