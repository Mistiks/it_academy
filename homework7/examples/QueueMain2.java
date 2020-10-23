package homeworks.homework7.examples;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueMain2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Созданная очередь: " + queue);

        try {
            System.out.println("Голова очереди (метод element): " + queue.element());
        } catch (NoSuchElementException e) {
            System.out.println("Может, лучше сначала заполнить очередь, а потом вызывать element?");
        }

        System.out.println("Голова очереди (метод peek): " + queue.peek());

        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Очередь пуста, что с помощью remove удалять-то собрался?");
        }

        System.out.println(queue.poll());
    }
}
