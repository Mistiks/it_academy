package homeworks.homework7.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class CustomerMainConcurrent {
    static protected CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        PriorityBlockingQueue<CustomerOrderConcurrent> queue = new PriorityBlockingQueue<>(4);
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");
        executor.execute(new CustomerGiverConcurrent(queue));
        executor.execute(new CustomerTakerConcurrent(queue));

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Работа потоков завершена");
        }
        executor.shutdown();
    }
}