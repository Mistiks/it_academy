package homeworks.homework7.customersmultithread;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CustomerGiver implements Runnable {
    protected static final Object lock = new Object();
    private PriorityQueue<CustomerOrder> queue;

    List<CustomerOrder> customerList = new ArrayList<>() {
        {
            add(new CustomerOrder(1, 27.0, "customer1"));
            add(new CustomerOrder(4, 13.0, "customer2"));
            add(new CustomerOrder(2, 13.5, "customer3"));
            add(new CustomerOrder(8, 4.3, "customer4"));
            add(new CustomerOrder(26, 2.0, "customer5"));
            add(new CustomerOrder(15, 29.7, "customer6"));
            add(new CustomerOrder(9, 5.0, "customer7"));
            add(new CustomerOrder(2, 67.3, "customer8"));
            add(new CustomerOrder(1, 14.0, "customer9"));
        }
    };

    public CustomerGiver(PriorityQueue<CustomerOrder> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;

        try {
            for (int i = 0; i < this.customerList.size(); i++) {
                if (this.queue.size() >= 4) {
                    counter++;
                    System.out.println("Количество попыток записи в занятую очередь: " + counter);
                    i--;
                    Thread.sleep(500);

                    if (counter == 4) {
                        System.out.println("Слишком много попыток записи в занятую очередь.");
                        CustomerMain.latch.countDown();
                        break;
                    }
                } else {
                    synchronized (lock) {
                        this.queue.offer(this.customerList.get(i));
                    }
                    System.out.println("В очередь добавлен: " + this.customerList.get(i).toString());
                    Thread.sleep(500);
                    counter = 0;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CustomerMain.latch.countDown();
    }
}
