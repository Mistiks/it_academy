package homeworks.homework7.customersmultithread;

import java.util.PriorityQueue;

public class CustomerTaker implements Runnable {
    private PriorityQueue<CustomerOrder> queue;

    public CustomerTaker(PriorityQueue<CustomerOrder> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        CustomerOrder order;
        while (true) {
            synchronized (CustomerGiver.lock) {
                if (queue.isEmpty()) {
                    System.out.println("Очередь пуста. Прекращение работы.");
                    CustomerMain.latch.countDown();
                    return;
                }

                order = this.queue.poll();
            }

            order.setPrice(order.getOrderAmount() * 10d);
            System.out.println("Обработка очереди: " + order.toString() + ", order price: " + order.getPrice());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}