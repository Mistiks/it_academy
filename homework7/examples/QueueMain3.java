package homeworks.homework7.examples;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain3 {
    public static void main(String[] args) {
        CustomerOrder c1 = new CustomerOrder(1, 27.0, "customer1");
        CustomerOrder c2 = new CustomerOrder(6, 50.0, "customer2");
        CustomerOrder c3 = new CustomerOrder(4, 43.0, "customer3");

        Queue<CustomerOrder> customerOrders = new PriorityQueue<>();
        customerOrders.offer(c1);
        customerOrders.offer(c2);
        customerOrders.offer(c3);
        while (!customerOrders.isEmpty()) {
            System.out.println(customerOrders.poll());
        }
    }
}
