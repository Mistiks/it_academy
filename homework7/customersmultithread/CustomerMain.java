package homeworks.homework7.customersmultithread;

import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomerMain {
    static protected CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        PriorityQueue<CustomerOrder> queue = new PriorityQueue<>();
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");
        executor.execute(new CustomerGiver(queue));
        executor.execute(new CustomerTaker(queue));

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Работа потоков завершена");
        }
        executor.shutdown();
    }
}
