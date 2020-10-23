package homeworks.homework7.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class CustomerGiverConcurrent implements Runnable {
    private PriorityBlockingQueue<CustomerOrderConcurrent> queue;

    List<CustomerOrderConcurrent> customerList = new ArrayList<>() {
        {
            add(new CustomerOrderConcurrent(1, 27.0, "customer1"));
            add(new CustomerOrderConcurrent(4, 13.0, "customer2"));
            add(new CustomerOrderConcurrent(2, 13.5, "customer3"));
            add(new CustomerOrderConcurrent(8, 4.3, "customer4"));
            add(new CustomerOrderConcurrent(26, 2.0, "customer5"));
            add(new CustomerOrderConcurrent(15, 29.7, "customer6"));
            add(new CustomerOrderConcurrent(9, 5.0, "customer7"));
            add(new CustomerOrderConcurrent(2, 67.3, "customer8"));
            add(new CustomerOrderConcurrent(1, 14.0, "customer9"));
        }
    };

    public CustomerGiverConcurrent(PriorityBlockingQueue<CustomerOrderConcurrent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < this.customerList.size(); i++) {
                if (this.queue.size() >= 4) {
                    i--;
                } else {
                    this.queue.put(this.customerList.get(i));
                    System.out.println("В очередь добавлен: " + this.customerList.get(i).toString());
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CustomerMainConcurrent.latch.countDown();
    }
}
