package homeworks.homework7.concurrent;

import homeworks.homework7.customersmultithread.CustomerOrder;
import java.util.concurrent.PriorityBlockingQueue;

public class CustomerTakerConcurrent implements Runnable {
    private PriorityBlockingQueue<CustomerOrderConcurrent> queue;

    public CustomerTakerConcurrent(PriorityBlockingQueue<CustomerOrderConcurrent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        CustomerOrderConcurrent order;
        while (true) {
            if (queue.isEmpty()) {
                System.out.println("Очередь пуста. Прекращение работы.");
                CustomerMainConcurrent.latch.countDown();
                break;
            }

            try {
                order = this.queue.take();
                order.setPrice(order.getOrderAmount() * 10d);
                System.out.println("Обработка очереди: " + order.toString() + ", order price: " + order.getPrice());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}